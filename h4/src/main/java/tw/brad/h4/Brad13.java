package tw.brad.h4;

import java.util.Set;

import tw.brad.dao.CourseDao;
import tw.brad.model.Course;
import tw.brad.model.Student;

public class Brad13 {

	public static void main(String[] args) {
		CourseDao cDao = new CourseDao();
		Course course = cDao.get(5);
		Set<Student> students = course.getStudents();
		for (Student student : students) {
			System.out.println(student.getSname());
		}
	}

}
