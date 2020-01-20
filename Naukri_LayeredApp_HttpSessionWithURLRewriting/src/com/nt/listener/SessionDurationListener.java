package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionDurationListener implements HttpSessionListener {
	private long start,end;
	public SessionDurationListener() {
		System.out.println("SessionDurationListener:0-param constructor");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc=null;
		System.out.println("SessionDurationListener.sessionCreated()");
		start=System.currentTimeMillis();
		//get ServletContext obj
		sc=se.getSession().getServletContext();
		sc.log("Session started at"+new Date());
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionDurationListener.sessionDestroyed()");
		ServletContext sc=null;
		end=System.currentTimeMillis();
		//get ServletContext obj
		sc=se.getSession().getServletContext();
		sc.log("Session ended at"+new Date());
		sc.log("session duration::"+(end-start)+  "ms");
	}

}
