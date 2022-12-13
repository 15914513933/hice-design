FROM ascdc/jdk8
ADD ./target/hice-design.jar hice-design.jar
ENTRYPOINT exec java -jar -Dspring.profiles.active=pro /hice-design.jar