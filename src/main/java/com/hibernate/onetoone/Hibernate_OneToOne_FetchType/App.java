package com.hibernate.onetoone.Hibernate_OneToOne_FetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Aadhar.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		Person person =  session.get(Person.class,101);
		Aadhar aadhar = person.getAadhar();
		System.out.println(person);
		System.out.println(aadhar);


		tran.commit();
		session.close();
		sf.close();



	}
}

