package tw.brad.h4;

import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.utils.HibernateUtil;

public class Brad03 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Member member = session.get(Member.class, 9);
			
			if (member != null) {
				//----------- 
				byte[] icon = member.getIcon();
				if (icon != null) {
					FileOutputStream fout = new FileOutputStream("dir2/brad.png");
					fout.write(icon);
					fout.flush();
					fout.close();
				}
				//---------------
				
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
			if (transaction !=null) {
				transaction.rollback();
			}
		}
	}

}
