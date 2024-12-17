package tw.brad.h4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.dao.CourseDao;
import tw.brad.dao.StudentDao;
import tw.brad.model.Course;
import tw.brad.model.Student;
import tw.brad.utils.HibernateUtil;

public class Brad10 {

	public static void main(String[] args) {
//		StudentDao sDao = new StudentDao();
//		Student s1 = sDao.getStudent(1);
//		System.out.println(s1.getSname());
		
//		CourseDao cDao = new CourseDao();
//		Course c1 = cDao.getCourse(1);
//		Course c2 = cDao.getCourse(2);
		
//		s1.addCourse(c1);
//		s1.addCourse(c2);
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Student s1 = session.get(Student.class, 2);
			Course c1 = session.get(Course.class, 2);
			Course c2 = session.get(Course.class, 4);
			Course c3 = session.get(Course.class, 3);
			s1.addCourse(c1);
			s1.addCourse(c2);
			s1.addCourse(c3);
			
			Transaction transaction = session.beginTransaction();
			session.merge(s1);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
