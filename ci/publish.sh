#!/bin/bash

set -e

VERSION_TYPE=$1

if [[ -z "$VERSION_TYPE" ]]; then
  echo "Error: No version type provided (expected 'major', 'minor', or 'patch')"
  exit 1
fi
echo "Update type: $VERSION_TYPE"

VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "Current version: $VERSION"

if [[ "$VERSION" =~ ^([0-9]+)\.([0-9]+)\.([0-9]+)$ ]]; then
  MAJOR=${BASH_REMATCH[1]}
  MINOR=${BASH_REMATCH[2]}
  PATCH=${BASH_REMATCH[3]}
else
  echo "Error: Version format is incorrect: $VERSION"
  exit 1
fi

case "$VERSION_TYPE" in
  major)
    echo "Major version definition"
    MAJOR=$((MAJOR + 1))
    MINOR=0
    PATCH=0
    ;;
  minor)
    echo "Minor version definition"
    MINOR=$((MINOR + 1))
    echo "Test incremented minor: $MINOR"
    PATCH=0
    echo "Test zero patch: $PATCH"
    ;;
  patch)
    echo "Patch version definition"
    PATCH=$((PATCH + 1))
    ;;
  *)
    echo "Invalid version type: $VERSION_TYPE (expected 'major', 'minor', or 'patch')"
    exit 1
    ;;
esac

echo "Major result - $MAJOR"
echo "Minor result - $MINOR"
echo "Patch result - $PATCH"

NEW_VERSION="$MAJOR.$MINOR.$PATCH"
echo "NEW_VERSION is $NEW_VERSION"
echo "NEW_VERSION=$NEW_VERSION" >> $GITHUB_ENV

echo "Updating version to $NEW_VERSION"
mvn versions:set -DnewVersion=$NEW_VERSION
echo "Set version - SUCCESS"
mvn versions:commit
echo "Version commit - SUCCESS"
