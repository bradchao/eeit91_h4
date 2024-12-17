package tw.brad.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Student;
import tw.brad.utils.HibernateUtil;

public class StudentDao {
	public Student getStudent(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Student.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.merge(student);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
