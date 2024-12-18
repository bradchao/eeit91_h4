package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Student;
import tw.brad.utils.HibernateUtil;

public class StudentDao {
	public void add(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public Student update(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.merge(student);
			transaction.commit();
			return get(student.getId());
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void remove(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.remove(student);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Student get(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Student.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<Student> getAll() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Student", Student.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
