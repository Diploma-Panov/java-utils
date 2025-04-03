VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

if [[ "$VERSION" =~ ^([0-9]+)\.([0-9]+)\.([0-9]+)$ ]]; then
  MAJOR=${BASH_REMATCH[1]}
  MINOR=${BASH_REMATCH[2]}
  PATCH=${BASH_REMATCH[3]}
else
  echo "Error: Version format is incorrect: $VERSION"
  exit 1
fi

case "${{ github.event.inputs.version_type }}" in
  major)
    ((MAJOR++))
    MINOR=0
    PATCH=0
    NEW_VERSION="$MAJOR.$MINOR.$PATCH"
    ;;
  minor)
    ((MINOR++))
    PATCH=0
    NEW_VERSION="$MAJOR.$MINOR.$PATCH"
    ;;
  patch)
    ((PATCH++))
    NEW_VERSION="$MAJOR.$MINOR.$PATCH"
    ;;
  *)
    echo "Invalid version type"
    exit 1
    ;;
esac
mvn versions:set -DnewVersion=$NEW_VERSION
mvn versions:commit