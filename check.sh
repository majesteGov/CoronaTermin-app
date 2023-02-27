#!/bin/bash
base=$(cat base.txt)
webapp="$base-java"
manager="$base-manager"

curl https://informatik.hs-bremerhaven.de/$webapp/hello

