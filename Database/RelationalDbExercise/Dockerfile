FROM openjdk:11
VOLUME /tmp
#COPY shadi-android-firebase-adminsdk-2var2-beaeb74caa.json shadi-android-firebase-adminsdk-2var2-beaeb74caa.json
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
