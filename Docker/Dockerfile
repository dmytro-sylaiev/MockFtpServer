FROM gradle:8.9.0-jdk11
USER root

#FAKE OR STUB to switch between modes (STUB is default one)
ENV MODE=STUB
RUN mkdir /opt/ftpStub
COPY MockFtpServer-3.2.1-account.jar /opt/ftpStub/
CMD java -DMODE=$MODE -jar /opt/ftpStub/MockFtpServer-3.2.1-account.jar
