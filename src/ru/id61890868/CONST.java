package ru.id61890868;

public class CONST {
	
	public class test{
		public static final String testReqToBase1 = "SELECT user.name, card.title FROM user,"
				+ " user_card, card where user.id = user_card.user_id "
				+ "and card.id = user_card.card_id ORDER by 1";
		
		public static final String testReqToBase2 = "select COUNT(*) FROM user";
	}
	
	public class baseAccess{
		public static final String basePath = "jdbc:mysql://node30616-cardbase.mircloud.host/cards";
		public static final String baseLog = "root";
		public static final String basePass = "XugKRpv1Iy";
	}
	
	
	
	public class params{
		public static final String name = "name";
		public static final String id   = "id";
		public static final String pict = "pict";
		public static final String date = "date";
		public static final String text = "text";
		
	}
}
