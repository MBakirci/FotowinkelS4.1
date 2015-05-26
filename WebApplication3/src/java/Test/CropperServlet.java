package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.net.ftp.FTP;

/**
 *
 * @author Gebruiker
 */
public class CropperServlet extends HttpServlet {
  public void service(HttpServletRequest request, 
                     HttpServletResponse response) throws ServletException, IOException
  {
    //Get all the parameters which were populated by JCrop
    int x1=Integer.parseInt(request.getParameter("dataX"));
    int y1=Integer.parseInt(request.getParameter("dataY"));
    int h=Integer.parseInt(request.getParameter("dataHeight"));
    int w=Integer.parseInt(request.getParameter("dataWidht"));
   
    
    System.out.println(x1+" "+y1+" "+w+" "+h);
    
    //Get the file name from the server
    String file=request.getParameter("file");
        
    //Get the buffered image reference
    URL url = new URL(file);
    BufferedImage image=ImageIO.read(url);

    //Get the sub image
    BufferedImage out=image.getSubimage(x1,y1,w,h);

    //Store the image to a new file
    File tmp = File.createTempFile(Long.toString(System.currentTimeMillis()), ".jpg");
    ImageIO.write(out,"jpg",tmp);
    String name = tmp.getName();
    
    //Upload file to FTP SERVER
    FTPUpload crUpload = new FTPUpload();
    crUpload.UploadFile("Henk@yolo.nl", tmp.toString(),name);
    
    //delete temp file after upload
    tmp.delete();
    
    //Sending the output to the client by showing the cropped image with dimensions
    PrintWriter printer=response.getWriter();
    System.out.println("Bestand geupload met hoogte: " + h + "en breedte: " + w);
    response.setContentType("text/html");
  }
  
  
}