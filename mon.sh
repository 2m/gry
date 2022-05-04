#!/bin/sh
while :
do
  TEXT=$(maim -m 10 --geometry 100x30+674+360 | tesseract - -)
  echo "$(date +%s),$TEXT" >> log.txt
  sleep 1
done
