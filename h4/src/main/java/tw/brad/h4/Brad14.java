package tw.brad.h4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tw.brad.dao.StudentDao;
import tw.brad.model.Course;
import tw.brad.model.Student;

public class Brad14 extends JFrame{
	private JLabel name;
	private JButton add;
	private StudentDao sDao;
	private Student s;
	private CourseMenu menu;
	
	public Brad14() {
		super("選課");
		
		sDao = new StudentDao();
		s = sDao.get(9);
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		
		add = new JButton("新選");
		name = new JLabel(s.getSname());
		menu = new CourseMenu();
		top.add(name); top.add(menu); top.add(add);
		
		add(top, BorderLayout.NORTH);
		
		setSize(640,  480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Course course = menu.getSelectedCourse();
				s.addCourse(course);
				s = sDao.update(s);
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Brad14();
	}

}
