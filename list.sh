#!/bin/bash
base=$(cat base.txt)
name="$base-java"
manager="$base-manager"
curl -s --netrc-file $HOME/.netrc  "https://informatik.hs-bremerhaven.de/$manager/text/list"

