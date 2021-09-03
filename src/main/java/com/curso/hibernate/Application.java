package com.curso.hibernate;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Application
{
	public static void main( String[] args )
	{
		//Create the student object.
    	User user = new User();
 
    	//Setting the object properties.
    	user.setUserName("Luis");
    	user.setPassword("Luis123");
 
 
    	Transaction tx = null;
    	//Get the session object.
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	try{
              //Start hibernate session.
    	      tx = session.beginTransaction();
 
              //Insert a new student record in the database.
    	      session.save(user); 
 
              //Commit hibernate transaction if no exception occurs.
    	      tx.commit();
    	      System.out.println("Saved Successfully.");
    	  }catch (HibernateException e) {
    	     if(tx!=null){
                 //Roll back if any exception occurs. 
    	         tx.rollback();
    	     }
    	     e.printStackTrace(); 
    	  }finally {
             //Close hibernate session.
    	     session.close(); 
    	  }
    }//fin main
}