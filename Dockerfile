FROM openjdk:11
ADD target/ProjetoFinal.jar ProjetoFinal.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ProjetoFinal.jar"]