package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;

import tw.brad.model.Course;
import tw.brad.model.Student;
import tw.brad.utils.HibernateUtil;

public class CourseDao {
	public List<Course> getAll(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}

	
	
}
