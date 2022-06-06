#!/bin/sh
cd /config/workspace/codingTest/
fileCheck = $(git status -s)
echo "$(filecheck)"
if [ -z "$(fileCheck)"];then
       echo "not changed"
	exit
fi

git checkout dev
git pull origin dev
git add .
git commit -m "$(tail -n 1 /config/workspace/codingTest/history.txt)"
git push origin dev
