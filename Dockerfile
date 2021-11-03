FROM openjdk:11
ADD target/ProjetoFinal-0.0.1-SNAPSHOT.jar ProjetoFinal.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ProjetoFinal.jar"]