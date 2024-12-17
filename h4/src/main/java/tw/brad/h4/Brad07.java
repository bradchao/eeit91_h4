package tw.brad.h4;

import tw.brad.dao.UserDao;
import tw.brad.model.Bike;
import tw.brad.model.User;

public class Brad07 {

	public static void main(String[] args) {
		UserDao dao = new UserDao();

		User user = new User();
		user.setName("Brad10");
		//dao.save(user);
		
		Bike b1 = new Bike();
		b1.setBrand("G2");
		b1.setSpeed(1);
		b1.setUser(user);
		user.addBike(b1);
		
		Bike b2 = new Bike();
		b2.setBrand("M2");
		b2.setSpeed(1.2);
		b2.setUser(user);
		user.addBike(b2);
		
		//dao.update(user);
		
		dao.save(user);
		
	}

}
