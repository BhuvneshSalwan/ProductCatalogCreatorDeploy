package com.xplanck.DBDao;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSessionFactory {

	public static SessionFactory sessionFac = null;
	
	public static SessionFactory getSessionFactory(){
	
		if(sessionFac == null)
		{
			//File configFile = new File("C:\\Users\\bhuvnesh\\Documents\\Eclipse_Workspace\\AdvJava_Workspace\\CopyProductCatalogCreator\\src\\main\\resources\\hibernate.cfg.xml");
			
			//File configFile = new File("C:\\Users\\bhuvnesh\\Eclipse_Workspace\\Xplanck\\Core\\ProductCatalogCreator2\\src\\main\\resources\\hibernate.cfg.xml");
			
		    //File configFile = new File("src/main/resources/hibernate.cfg.xml");
			
			//sessionFac = new Configuration().configure(configFile).buildSessionFactory();
			sessionFac = new Configuration().configure().buildSessionFactory();
			
			return sessionFac;
		}
		else{
			return sessionFac;
		}
	}

}
