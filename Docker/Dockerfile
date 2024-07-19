FROM gradle:8.9.0-jdk11
USER root

RUN mkdir /opt/ftpStub
COPY MockFtpServer-3.2.0-account.jar /opt/ftpStub/
CMD java -jar /opt/ftpStub/MockFtpServer-3.2.0-account.jar
