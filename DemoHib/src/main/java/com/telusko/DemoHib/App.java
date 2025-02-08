package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Transaction;
/*
  Hello world!
 */
public class App 
{
    public static void main( String[] args){
    	Alien telusko = new Alien();
    	telusko.setAid(103);
    	telusko.setAname("Amitaa");
    	telusko.setColor("blue");
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
//    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory();
    	
    	//presist the data store data into database
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(telusko);
       tx.commit();
    }
}
