package org.mockftpserver.entry;

import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;
import org.mockftpserver.stub.StubFtpServer;

public class EntryPoint {

    private static final String MODE_KEY_PROPERTY = "MODE";

    public static void main(String[] args) {
        if (System.getProperty(MODE_KEY_PROPERTY).equals("FAKE")) {
            startFakeFTPServer();
        } else {
            startStubFTPServer();
        }
    }

    private static void startFakeFTPServer() {
        FakeFtpServer fakeFtpServer = new FakeFtpServer();

        FileSystem fileSystem = new UnixFakeFileSystem();
        fileSystem.add(new DirectoryEntry("/data"));
        fileSystem.add(new FileEntry("/data/file1.txt", "abcdef 1234567890"));
        fakeFtpServer.setFileSystem(fileSystem);
        UserAccount userAccount = new UserAccount("joe", "joe123", "/data");
        userAccount.setAccountRequiredForLogin(true);
        fakeFtpServer.addUserAccount(userAccount);
        fakeFtpServer.start();
    }

    private static void startStubFTPServer() {
        StubFtpServer stubFtpServer = new StubFtpServer();
        stubFtpServer.start();
    }

}
