package tw.brad.h4;

import java.util.List;

import tw.brad.dao.UserBikeDao;

public class Brad08 {
	public static void main(String[] args) {
		List<UserBikeDao> ubikes =  UserBikeDao.queryHQL();
		System.out.println(ubikes.size());
		int nowId = -1;
		for (UserBikeDao ubike : ubikes) {
			if (ubike.getId() != nowId) {
				System.out.printf("%d:%s:\n", 
						ubike.getId(), ubike.getName());
				nowId = ubike.getId(); 
			}
			System.out.printf("\t%d:%s:%f\n", 
					ubike.getBid(), ubike.getBrand(), ubike.getSpeed());
		}
	}
}
