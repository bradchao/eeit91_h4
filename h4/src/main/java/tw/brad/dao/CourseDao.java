package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Course;
import tw.brad.utils.HibernateUtil;

public class CourseDao {
	public void add(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.persist(course);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void update(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.merge(course);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void remove(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.remove(course);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Course get(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Course.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<Course> getAll() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	
}
