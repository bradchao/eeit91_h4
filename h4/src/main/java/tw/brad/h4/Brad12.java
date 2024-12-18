package tw.brad.h4;

import tw.brad.dao.CourseDao;
import tw.brad.model.Course;

public class Brad12 {

	public static void main(String[] args) {
		Course c1 = new Course("Java");
		Course c2 = new Course("Hibernate");
		Course c3 = new Course("Spring");
		Course c4 = new Course("View.js");
		Course c5 = new Course("Node.js");
		Course c6 = new Course("MySQL");
		
		CourseDao dao = new CourseDao();
		dao.add(c1);
		dao.add(c2);
		dao.add(c3);
		dao.add(c4);
		dao.add(c5);
		dao.add(c6);
	}

}
