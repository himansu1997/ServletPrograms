package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    String fname=null;
	    ServletContext sc=null;
	    File file=null;
	    String uploadLocation=null;
	    String mimeType=null;
	    InputStream is=null;
	    OutputStream os=null;
	    byte[] buffer=null;
	    int bytesRead=0;
		//read  addtional request param value
	    fname=req.getParameter("file").trim();
	    //get ServletContext obj
	    sc=req.getServletContext();
	    //get Context param value
	    uploadLocation=sc.getInitParameter("uploadLocation");
	    //Locate the file
	    file=new File(uploadLocation+"/"+fname);
	    //get the lenght of the and make it  response content  legnth
	    res.setContentLengthLong(file.length());
	    //get the MIME type of file and make it  response content type
	    mimeType=sc.getMimeType(uploadLocation+"/"+fname);
	    res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
	    //create  InputStream Locating the file
	    is=new FileInputStream(file);
	    //create output stream pointing response obj
	    os=res.getOutputStream();
	    //set Content-Disposition response header value with "attachment"
	    res.addHeader("Content-Disposition","attachment;fileName="+fname);
	    //write buffer based logic  to complete file downloading activitity
	/*    buffer=new byte[4096];
	    while((bytesRead=is.read(buffer))!=-1) {
	    	os.write(buffer,0,bytesRead);
	    }
	    //close stream
	    is.close();
	    os.close(); */
	    IOUtils.copy(is,os);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);
	}

}
