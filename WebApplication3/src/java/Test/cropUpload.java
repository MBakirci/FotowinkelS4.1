/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Gebruiker
 */
public class cropUpload {
    
    public cropUpload(){
        
    }

    public void UploadFile(String User, String path, String name) {
        String server = "212.64.126.219";
        int port = 9942;
        String user = "asror";
        String pass = "asror";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: uploads first file using an InputStream
            //File firstLocalFile = ;
            String firstRemoteFile = "";
            firstRemoteFile = User + "/" + name;
            InputStream inputStream = new FileInputStream(new File(path));

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");

            }

            /*//APPROACH #2: uploads second file using an OutputStream
             File secondLocalFile = new File("C://Users/Asror/Desktop/mehmet2.txt");
             String secondRemoteFile = "/Upload123/mehmet4.txt";
             inputStream = new FileInputStream(secondLocalFile);
 
             System.out.println("Start uploading second file");
             OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
             byte[] bytesIn = new byte[4096];
             int read = 0;
 
             while ((read = inputStream.read(bytesIn)) != -1) {
             outputStream.write(bytesIn, 0, read);
             }
             inputStream.close();
             outputStream.close();
 
             boolean completed = ftpClient.completePendingCommand();
             if (completed) {
             System.out.println("The second file is uploaded successfully.");
             }*/
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
