#!/bin/bash
base=$(cat base.txt)
webapp="$base-java"
manager="$base-manager"
url="https://informatik.hs-bremerhaven.de"

curl -f -n -T target/$webapp.war "$url/$manager/text/deploy?path=/$webapp&update=true" &&
  echo "deploy success" &&
  exit 0

#failed
exit 1

