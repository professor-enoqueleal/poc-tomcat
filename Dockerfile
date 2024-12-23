# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Instale o curl
RUN apt-get update && apt-get install -y curl && apt-get clean

# Defina as variáveis de ambiente para o Tomcat
ENV CATALINA_HOME /opt/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

# Baixe e instale o Tomcat
RUN mkdir -p $CATALINA_HOME \
    && curl -L -O https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.98/bin/apache-tomcat-9.0.98.tar.gz \
    && tar -zxf apache-tomcat-9.0.98.tar.gz --strip-components=1 -C $CATALINA_HOME \
    && rm apache-tomcat-9.0.98.tar.gz

# Copie o arquivo WAR da aplicação para o diretório webapps do Tomcat
# (substitua 'seu-app.war' pelo nome do seu arquivo WAR)
COPY target/poc-tomcat.war $CATALINA_HOME/webapps/

# COPY tomcat/tomcat-users.xml $CATALINA_HOME/conf/tomcat-users.xml
COPY tomcat/conf/* $CATALINA_HOME/conf/
COPY tomcat/lib/* $CATALINA_HOME/lib/

# Exponha a porta 8080
EXPOSE 8080

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]