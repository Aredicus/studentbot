FROM ubuntu:latest
LABEL authors="aredicus"

ENTRYPOINT ["top", "-b"]