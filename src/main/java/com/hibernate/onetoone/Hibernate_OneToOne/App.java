package com.hibernate.onetoone.Hibernate_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{
		Person person = new Person();
		person.setPersonId(101);
		person.setPersonName("Sai Charan");

		Aadhar aadhar = new Aadhar();
		aadhar.setAadharId(1);
		aadhar.setAadharNo(1234852474555l);

		//Adding the Aadhar obj into Person
		person.setAadhar(aadhar);
		
		//Adding  the Person obj into Aadhar
		//aadhar.setPerson(person);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Aadhar.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tran = session.beginTransaction();

		session.save(person);


		tran.commit();
		session.close();
		sf.close();



	}
}
