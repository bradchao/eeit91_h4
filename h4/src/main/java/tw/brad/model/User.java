package tw.brad.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//-------------------
	public User() {
		bikes = new LinkedList<Bike>();
	}
	
	@OneToMany(mappedBy = "user", 
				cascade = CascadeType.ALL)
	private List<Bike> bikes;
	public List<Bike> getBikes() {
		return bikes;
	}
	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}
	public void addBike(Bike bike) {
		bike.setUser(this);
		bikes.add(bike);
	}
	
}
