FROM frolvlad/alpine-oraclejdk8:slim
WORKDIR /$APP
ADD . $APP/
EXPOSE 8000
RUN $APP/./gradlew build --debug
WORKDIR $APP/build/libs
ENTRYPOINT java -jar rv-User-service-0.1.0.jar
