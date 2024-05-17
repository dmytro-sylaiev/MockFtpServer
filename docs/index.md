---
layout: default
title: MockFtpServer
---  

# MockFtpServer - Providing a Fake/Stub FTP Server

The **MockFtpServer** project provides mock/dummy FTP server implementations that can be very
useful for testing of FTP client code. Two FTP Server implementations are provided, each at a different
level of abstraction.

**FakeFtpServer** provides a higher-level abstraction for an FTP server and is suitable for most testing
and simulation scenarios. You define a filesystem (virtual, in-memory) containing an arbitrary set of
files and directories. These files and directories can (optionally) have associated access permissions.
You also configure a set of one or more user accounts that control which users can login to the FTP server,
and their home (default) directories. The user account is also used when assigning file and directory
ownership for new files. See [FakeFtpServer Features and Limitations](./fakeftpserver-features.html).

**StubFtpServer** is a "stub" implementation of an FTP server. It supports the main FTP commands by
implementing command handlers for each of the corresponding low-level FTP server commands (e.g. RETR,
DELE, LIST). These *CommandHandler*s can be individually configured to return custom data or reply codes,
allowing simulation of a complete range of both success and failure scenarios. The *CommandHandler*s can
also be interrogated to verify command invocation data such as command parameters and timestamps.
See [StubFtpServer Features and Limitations](./stubftpserver-features.html).

See the [FakeFtpServer or StubFtpServer?](./fakeftpserver-versus-stubftpserver.html) page for more
information on deciding whether to use **FakeFtpServer** or **StubFtpServer**.

The **MockFtpServer** project is written in Java, and is ideally suited to testing Java code. But because
communication with the FTP server is across the network using sockets, it can be used to test FTP client 
code written in any language.

NOTE: The **MockFtpServer** project does not support **FTPS** or **SFTP**.

NOTE: Starting with **MockFtpServer** 2.4, the **Log4J** dependency has been replaced with [SLF4J](http://www.slf4j.org/).


## Requirements

The **MockFtpServer** project requires:

 *  Java (JDK) version 1.4 or later

 * The [SLF4J](http://www.slf4j.org/) API jar, accessible on the CLASSPATH. An SLF4J binding (logging
   framework-specific jar) is optional.


## Articles and References

 * [Implementing a FTP-Client in Java - Baeldung](https://www.baeldung.com/java-ftp-client)

 * [How to create a java FTP server mock](https://itsiastic.wordpress.com/2012/11/08/how-to-create-a-java-ftp-server-mock/)


## Maven Support

For projects built using [Maven](http://maven.apache.org/), **MockFtpServer** is now available
from the **Maven Central Repository**. Add a dependency to your POM like this:

```
  <dependency>
    <groupId>org.mockftpserver</groupId>
    <artifactId>MockFtpServer</artifactId>
    <version>3.2.0</version>
    <scope>test</scope>
  </dependency>
```