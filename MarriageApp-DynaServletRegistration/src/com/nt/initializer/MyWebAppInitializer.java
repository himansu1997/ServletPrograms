package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
	static {
		System.out.println("MyWebAppInitializer: static block");
	}
	
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer::0-param constructor");
	}
	

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
		System.out.println("MyWebAppInitializer.onStartup(-,-)");
	         MarriageServlet  ms=null;
	         ServletRegistration.Dynamic reg=null;
	         //create Servlet class obj
	         ms=new MarriageServlet();
	         //register SErvlet comp
	         reg=ctx.addServlet("marriage",ms);
	         reg.addMapping("/marriageurl");
	         reg.setLoadOnStartup(1);
	}//onStartup(-,-)

}//class
