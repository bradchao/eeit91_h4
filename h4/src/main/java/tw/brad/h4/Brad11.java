package tw.brad.h4;

import tw.brad.dao.StudentDao;
import tw.brad.model.Student;

public class Brad11 {

	public static void main(String[] args) {
		Student s1 = new Student("Brad");
		Student s2 = new Student("Amy");
		Student s3 = new Student("Peter");
		Student s4 = new Student("John");
		Student s5 = new Student("Kevin");
		StudentDao dao = new StudentDao();
		dao.add(s1);
		dao.add(s2);
		dao.add(s3);
		dao.add(s4);
		dao.add(s5);
	}

}
