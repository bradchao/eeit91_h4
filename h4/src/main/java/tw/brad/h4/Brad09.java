package tw.brad.h4;

import java.util.List;
import java.util.Queue;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import tw.brad.utils.HibernateUtil;

public class Brad09 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String sql = "SELECT * FROM food";
			NativeQuery query = session.createNativeQuery(sql);
			query.setFirstResult(10);
			query.setMaxResults(10);
			List<Object> list = query.getResultList();
			
			for (Object row: list) {
				Object[] food = (Object[])row;
				System.out.println(food[1]);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
