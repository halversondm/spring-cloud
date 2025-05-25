#!/bin/zsh

find . -name 'Dockerfile' | while read dockerfile; do
  dir=$(dirname "$dockerfile")
  imagename=$(basename "$dir")
  docker build -t "spring-cloud-${imagename}:latest" "$dir"
done