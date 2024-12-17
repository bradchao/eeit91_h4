package tw.brad.h4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.utils.HibernateUtil;

public class Brad03 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Member member = session.get(Member.class, 3);
			
			if (member != null) {
				Info info = member.getInfo();
				System.out.printf("%s:%s:%s\n", member.getAccount(), member.getPasswd(), member.getName());
				System.out.printf("%s:%s\n", info.getTel(), info.getBirthday());
				
				transaction = session.beginTransaction();
				session.remove(member);
				transaction.commit();
				System.out.println("DELETE OK");
			}else {
				System.out.println("Not FOUND!");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
