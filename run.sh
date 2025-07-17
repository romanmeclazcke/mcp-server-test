#!/bin/bash
docker rmi mcp-server-test
docker build --no-cache -t mcp-server-test .
docker run --rm -i mcp-server-test