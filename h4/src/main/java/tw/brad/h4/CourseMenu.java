package tw.brad.h4;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import tw.brad.dao.CourseDao;
import tw.brad.model.Course;

public class CourseMenu extends JComboBox<String>{
	private MyModel myModel;
	private List<Course> courses;
	
	public CourseMenu() {
		
		courses = new CourseDao().getAll();
		
		myModel = new MyModel();
		setModel(myModel);
	}
	
	public Course getSelectedCourse() {
		return courses.get(getSelectedIndex());
	}
	
	
	private class MyModel extends DefaultComboBoxModel<String> {
		@Override
		public int getSize() {
			return courses.size();
		}

		@Override
		public String getElementAt(int index) {
			return courses.get(index).getCname();
		}
	}
	
}
