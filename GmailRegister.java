package com.te.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.assigmenthibernate.bean.Account;

public class GmailRegister extends GmailLogin {
	
	Scanner scanner  = new Scanner(System.in);
	EntityManagerFactory entityManagerFactory = null;
	EntityManager manager = null;
	EntityTransaction transaction  = null;
	
	public void register() {	
		System.out.println("Enter User_id ");
		int id = scanner.nextInt();
		System.out.println("Enter User_name ");
		String name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Password ");
		String pass = scanner.next();
		scanner.nextLine();
		System.out.println("Enter GMail ");
		String mail = scanner.nextLine();
		
		Account account = new Account();
		account.setUid(id);
		account.setName(name);
		account.setPass(pass);
		account.setMail(mail);
	
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("gmailData");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(account);
			System.out.println("Register Sucessfully..");

			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if (entityManagerFactory!=null) {
				entityManagerFactory.close();
			}
			if (manager!=null) {
				manager.close();
			}
		}	
	}

}
