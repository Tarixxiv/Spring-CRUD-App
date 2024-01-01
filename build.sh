#!/usr/bin/env bash

main () {
  cd ./aui-planet/; sh ./build.sh; cd ..
  cd ./aui-star/; sh ./build.sh; cd ..
  cd ./aui-gateway/; sh ./build.sh; cd ..
  cd ./aui-angular/; sh ./build.sh; cd ..
}

main "$@"
