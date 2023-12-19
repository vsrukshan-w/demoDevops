FROM ubuntu:latest
LABEL authors="vsruk"

ENTRYPOINT ["top", "-b"]