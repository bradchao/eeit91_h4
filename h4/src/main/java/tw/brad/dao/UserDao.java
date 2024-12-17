package tw.brad.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.model.User;
import tw.brad.utils.HibernateUtil;

public class UserDao {
	public void save(User user) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(user);
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public void update(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
			
		session.merge(user);
		//session.update(user);
			
		transaction.commit();
		session.close();
		
	}
}
