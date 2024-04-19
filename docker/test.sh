#!/bin/bash

cnt=2

echo -e "\n# Test IP HTTP"
for ((i=1; i<=cnt; i++))
do
    curl -s -k -L --max-time 2 http://144.22.131.24/api/info
    curl -s -k -L --max-time 2 http://144.22.131.24/api/actuator/health
    curl -s -k -L --max-time 2 http://132.226.251.107/rt-3.html | grep "ChatBot RT"
    echo ""
done

echo -e "\n# Test hostname HTTP"
for ((i=1; i<=cnt; i++))
do
    curl -s -k -L --max-time 2 http://brunobcp.com/api/info
    curl -s -k -L --max-time 2 http://brunobcp.com/api/actuator/health
    curl -s -k -L --max-time 2 http://brunobcp.com/rt-3.html | grep "ChatBot RT"
    echo ""
done

echo -e "\n# Test IP HTTPS (ssl)"
for ((i=1; i<=cnt; i++))
do
    curl -s -k -L --max-time 2 https://144.22.131.24/api/info
    curl -s -k -L --max-time 2 https://144.22.131.24/api/actuator/health
    curl -s -k -L --max-time 2 https://132.226.251.107/rt-3.html | grep "ChatBot RT"
    echo ""
done

echo -e "\n# Test hostname HTTPS (ssl)"
for ((i=1; i<=cnt; i++))
do
    curl -s -k -L --max-time 2 https://brunobcp.com/api/info
    curl -s -k -L --max-time 2 https://brunobcp.com/api/actuator/health
    curl -s -k -L --max-time 2 https://brunobcp.com/rt-3.html | grep "ChatBot RT"
    echo ""
done
