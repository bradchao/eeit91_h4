package tw.brad.h4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Cart;
import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.utils.HibernateUtil;

public class Brad05 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Member member = new Member();
			member.setAccount("brad08");
			member.setPasswd("123456");
			member.setName("Brad08");
			
			Info info = new Info();
			info.setTel("1234567");
			info.setBirthday("1999-05-02");
			member.setInfo(info);
			session.persist(member); 	// 資料庫
			
			Cart cart = new Cart();
			cart.setStatus("init08");
			cart.setLast("2024-12-17");
			cart.setMember(member);		// 重要
			session.persist(cart);

			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
