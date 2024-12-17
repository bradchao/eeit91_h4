package tw.brad.utils;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import tw.brad.model.Bike;
import tw.brad.model.Cart;
import tw.brad.model.Info;
import tw.brad.model.Member;
import tw.brad.model.User;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				
				config.addAnnotatedClass(Member.class);
				config.addAnnotatedClass(Info.class);
				config.addAnnotatedClass(Cart.class);

				config.addAnnotatedClass(User.class);
				config.addAnnotatedClass(Bike.class);

				registry = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties())
						.build();
				
				sessionFactory = config.buildSessionFactory(registry);
			}catch(Exception e) {
				System.out.println(e);
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				
			}
			
		}
		
		return sessionFactory;
	}
	
}
