package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppMonitoringListener  implements ServletContextListener {
  private long start,end;
	public WebAppMonitoringListener() {
		System.out.println("WebAppMonitoringListener.0-param constructor");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebAppMonitoringListener:contextInitialized()");
		ServletContext sc=null;
		start=System.currentTimeMillis();
		//get servletContext obj
		sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is deployed at::"+new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebAppMonitoringListener:contextDestroyed()");
		ServletContext sc=null;
		end=System.currentTimeMillis();
		
		//get servletContext obj
		sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is stopped/reloaded/undeployed at::"+new Date());
		sc.log(sc.getContextPath()+" is in deployment mode for "+(end-start)+" ms  continuosly");
	}
	
}
