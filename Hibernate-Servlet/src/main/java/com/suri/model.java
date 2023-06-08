package com.suri;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.suri.pojo.user;

public class model {
	
	private static  SessionFactory SessionFactory ;
	
	
public void datapage(user user) {
		try {
			Configuration config = new Configuration();
			config.configure("cfg.xml");

			SessionFactory sessionFactory = config.buildSessionFactory();

			Session session = sessionFactory.openSession();
           Transaction tr=session.beginTransaction();
	user user1=session.get(user.class, session);
	if (user1==null) {
		user1=new user();
		user.setName(null);
		
	} else {

	}
		   // session.save(user);
			tr.commit();
			session.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public void datafetch(String email, String password) {
		try {

			Configuration config = new Configuration();
			config.configure("cfg.xml");

			SessionFactory sessionFactory = config.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();
			
		user user=session.get(user.class, email);
	         user=session.get(user.class, password);
	        
			tx.commit();
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public void deletedata(user user) {
		try {

			Configuration config = new Configuration();
			config.configure("cfg.xml");

			SessionFactory sessionFactory = config.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();
			
		session.delete(user);
			tx.commit();
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updatedata(user user) {
		try {

			Configuration config = new Configuration();
			config.configure("cfg.xml");

			SessionFactory sessionFactory = config.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();
			
		    session.delete(user);
			tx.commit();
			session.close();
			sessionFactory.close();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static SessionFactory getSessionFactory() {
		return SessionFactory;
		
	}

}
