FROM openjdk:8

COPY ./build/libs/productcomparison-*.jar productcomparison.jar

ENTRYPOINT java -Xmx4096m -jar productcomparison.jar