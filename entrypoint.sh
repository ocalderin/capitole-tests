#!/bin/bash
set -x

echo "Checking if hub is ready"

READY=$(curl --silent http://selenium-hub:4444/status | jq -r '.value.ready')
while [ "$READY" != "true" ]
do
	sleep 1
	READY=$(curl --silent http://selenium-hub:4444/status | jq -r '.value.ready')
done

./mvnw test -Dexec=remote