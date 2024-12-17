package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.utils.HibernateUtil;

/*
 * SELECT u.id, u.name, b.id bid, b.uid, b.brand, b.speed FROM user u JOIN bike b ON u.id = b.uid
 */
public class UserBikeDao {
	private int id;
	private String name;
	private int bid;
	private int uid;
	private String brand;
	private double speed;
	
	public UserBikeDao(int id, String name, int bid, int uid, String brand, double speed) {
		this.id = id;
		this.name = name;
		this.bid = bid;
		this.uid = uid;
		this.brand = brand;
		this.speed = speed;
	}

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

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public static List<UserBikeDao> querySQL(){
		String sql = "SELECT u.id id, u.name name, b.id bid, b.uid uid, b.brand brand, b.speed speed" + 
						" FROM user u JOIN bike b ON u.id = b.uid";
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createNativeQuery(sql, UserBikeDao.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static List<UserBikeDao> queryHQL(){
		String hql = "SELECT new tw.brad.dao.UserBikeDao(u.id, u.name, b.id, u.id, b.brand, b.speed)" + 
				" FROM User u JOIN u.bikes b";
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery(hql, UserBikeDao.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
}
