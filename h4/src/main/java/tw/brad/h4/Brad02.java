package tw.brad.h4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.utils.HibernateUtil;

public class Brad02 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Member member = new Member();
			member.setAccount("brad04");
			member.setPasswd("123456");
			member.setName("Brad04");
			
			Info info = new Info();
			info.setTel("1234567");
			info.setBirthday("1999-04-02");
			
			member.setInfo(info);
			
			session.persist(member); 	// 資料庫
			
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
