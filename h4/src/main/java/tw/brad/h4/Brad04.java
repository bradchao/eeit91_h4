package tw.brad.h4;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.utils.HibernateUtil;

public class Brad04 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Member member = session.get(Member.class, 4);
			
			if (member != null) {
				Info info = member.getInfo();
				
				System.out.printf("%s:%s:%s\n", member.getAccount(), member.getPasswd(), member.getName());
				System.out.printf("%s:%s\n", info.getTel(), info.getBirthday());

				member.setAccount("tony01");
				member.setPasswd("654321");
				member.setName("Tony01");
				
				info.setTel("7654321");
				
				System.out.println("----");
				System.out.printf("%s:%s:%s\n", member.getAccount(), member.getPasswd(), member.getName());
				System.out.printf("%s:%s\n", info.getTel(), info.getBirthday());
				
				transaction = session.beginTransaction();
				session.merge(member);
				transaction.commit();
				System.out.println("Update OK");
			}else {
				System.out.println("Not FOUND!");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			if (transaction !=null) {
				transaction.rollback();
			}
		}

	}

}
