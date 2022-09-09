FROM gradle:jdk8
COPY --chown=gradle:gradle ./ .
WORKDIR .