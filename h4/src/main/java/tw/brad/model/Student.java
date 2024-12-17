package tw.brad.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sname;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	//------------------
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "sc",
			joinColumns = {@JoinColumn(name = "sid")},
			inverseJoinColumns = {@JoinColumn(name = "cid")}
	)
	private Set<Course> courses = new HashSet<Course>();


	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}
	
}
