package tw.brad.h4;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.dao.CourseDao;
import tw.brad.dao.StudentDao;
import tw.brad.model.Course;
import tw.brad.model.Student;
import tw.brad.utils.HibernateUtil;

public class Brad10 {

	public static void main(String[] args) {
		StudentDao sDao = new StudentDao();
		Student s1 = sDao.get(7);
		if (s1 != null) {
			System.out.printf("Welcome, %s\n", s1.getSname());
			
			CourseDao cDao = new CourseDao();
			List<Course> courses =  cDao.getAll();
			for (Course course: courses) {
				System.out.printf("%d. %s\n", course.getId(), course.getCname());
			}
			
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.print("Which course? ");
				int cid = scanner.nextInt();
				if (cid == 0) break;
				s1.addCourse(cDao.get(cid));
				System.out.println();
			}
			
			try(Session session = HibernateUtil.getSessionFactory().openSession()){
				Transaction transaction = session.beginTransaction();
				session.merge(s1);
				transaction.commit();
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		
		
	}

}
