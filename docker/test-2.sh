#!/bin/bash

cnt=10

echo -e "\n# Test hostname HTTPS (ssl)"
for ((i=1; i<=cnt; i++))
do
    curl -s -L --max-time 2 https://www.brunobcp.com/api/info
    curl -s -L --max-time 2 https://www.brunobcp.com/api/actuator/health
    curl -s -L --max-time 2 https://www.brunobcp.com/crud/actuator/health
    echo ""
done
