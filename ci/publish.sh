#!/bin/bash

set -e

VERSION_TYPE=$1

if [[ -z "$VERSION_TYPE" ]]; then
  echo "Error: No version type provided (expected 'major', 'minor', or 'patch')"
  exit 1
fi

VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

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
    ((MAJOR++))
    MINOR=0
    PATCH=0
    ;;
  minor)
    ((MINOR++))
    PATCH=0
    ;;
  patch)
    ((PATCH++))
    ;;
  *)
    echo "Invalid version type: $VERSION_TYPE (expected 'major', 'minor', or 'patch')"
    exit 1
    ;;
esac

NEW_VERSION="$MAJOR.$MINOR.$PATCH"

echo "Updating version to $NEW_VERSION"
mvn versions:set -DnewVersion=$NEW_VERSION
mvn versions:commit
