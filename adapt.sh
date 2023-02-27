#!/bin/bash
sed -i \
  -e "s/yourdatabase/${USER}_db/g" \
  -e "s/yourusername/$USER/g" \
  -e "s/yourpassword/$(grep '^password' ~/.my.cnf|cut -d= -f2)/g" \
  app/META-INF/context.xml
echo "docker-$USER" > base.txt
echo "Denke daran, dass Deine .netrc auch das Passwort 
aus ~/.my.cnf enthalten muss:
machine informatik.hs-bremerhaven.de login manager password DEINPASSWORD
"

