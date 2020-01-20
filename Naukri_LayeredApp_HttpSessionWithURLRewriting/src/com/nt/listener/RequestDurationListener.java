package com.nt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestDurationListener implements ServletRequestListener {
	private long start,end;
	
	public RequestDurationListener() {
		System.out.println("RequestDurationListener:0-param consturctor");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestDurationListener.requestInitialized()");
		start=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestDurationListener.requestDestroyed()");
		HttpServletRequest req;
		ServletContext sc=null;
		end=System.currentTimeMillis();
		//get rquest obj
		req=(HttpServletRequest)sre.getServletRequest();
		//get SErvletContext obj
		sc=req.getServletContext();
		//write to log file
		sc.log(req.getRequestURL()+" has taken "+(end-start)+"  ms to process the request");
	}
	

}
