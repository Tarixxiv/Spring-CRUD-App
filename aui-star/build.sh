#!/usr/bin/env bash

main () {
  JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64 mvn clean verify
  title="$(grep -n "org.opencontainers.image.title" Dockerfile | cut -f2 -d "=" | xargs)"
  version="$(grep -n "org.opencontainers.image.version" Dockerfile | cut -f2 -d "=" | xargs)"
  docker build \
  --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" \
  --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" \
  --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" \
  -t "${title}":"${version}" .
}

main "$@"