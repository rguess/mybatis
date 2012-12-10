package org.guess.mybatis.util;

public class RandomUtil {

	public final static String[] USERNAME = { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	public final static String[] FIRST_NAME = { "赵", "钱", "孙", "李", "周", "武",
			"郑", "王", "陈", "高", "钟", "唐", "杨" };

	public final static String LAST_NAME = "回家前就感冒了经过五小时车程头痛得很厉害下车后"
			+ "四处张望发现了身影他穿一套橄榄色的休闲装朝他走进他瞬间发现了我一手接过行礼一手拉住我便往停"
			+ "车场走去我们的见面没有任何激情就这样像亲人一样平平淡淡很自然的走到了一块接着他带我去吃饭原"
			+ "以为他要带我回他住所但他说住所太冷不温馨也不方便还告诉我说已经在宾馆开好房了其实我身体很"
			+ "不舒服感冒加上例假不知道为什么见到他却很想喝酒他说身体不舒服就别喝了而我却执意的说自己能喝他"
			+ "准备了一瓶红酒在饿着肚子的情况下我一瓶接一瓶一会一瓶酒就喝完了他是什么事也没有还是那么的镇定"
			+ "而我却醉得一塌糊涂连走路也不稳东倒西歪加上感冒和身上有例假身体简直是难受到了极点他扶我到宾馆将"
			+ "我扶到床上给我脱鞋盖被还问我要不要吃点什么水果我喝酒后冷得不行可宾馆的中央空调没有暖气就告诉他"
			+ "冷他便把我抱在怀里我在迷迷糊糊中听到他说我是有家庭的人我不能给你幸福我不能伤害你我希望你找到一"
			+ "个真正痛爱你的男人有一个幸福的家答应我遇到好的男人就嫁了好吗还说看着我这样压力很大我一直在晃着脑袋"
			+ "因为我脑子里只有晕除了什么也没有身体慢慢暖和他一直在问我要不要吃什么东西他去给卖他见我没反应就轻"
			+ "轻将我放下盖好被子随着一声门响他出去了不知道过了多久他回来了他卖了水还有感冒药问我好些没还说"
			+ "我不能喝酒还逞强说自己能喝听到他的唠叨心里真的好幸福有人关心有人爱真的好幸福";
	
	public static String[] ADDRESS ={"北京","湖南","天津","湖北","上海","广东","重庆",
		"海南","河北","四川","山西","贵州","辽宁","云南","吉林","陕西","河南","甘肃","江苏",
		"青海","浙江","台湾","安徽","西藏自治区","福建","内蒙古自治区","江西","广西壮族自治区",
		"山东","宁夏回族自治区","黑龙江","新疆维吾尔自治区"};
 
	public static String getUsername() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(USERNAME[(int) (Math.random() * 26)]);
		}
		return sb.toString();
	}
	
	public static String getNickname(){
		
		char[] nickname = new char[3];
		nickname[0] = FIRST_NAME[(int)(Math.random()*FIRST_NAME.length)].charAt(0);
		for (int i = 1; i < nickname.length; i++) {
			nickname[i] = LAST_NAME.charAt((int) (Math.random()*LAST_NAME.length()));
		}
		return new String(nickname);
	}
	
	public static String getPhone(){
		
		StringBuilder sb = new StringBuilder("1");
		for (int i = 0; i < 10; i++) {
			sb.append(String.valueOf((int)(Math.random()*10)));
		}
		return sb.toString();
	}
	
	public static String getPostcode(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append((int)(Math.random()*10));
		}
		return sb.toString();
	}
	
	public static String getAddress(){
		return ADDRESS[(int)(Math.random()*ADDRESS.length)];
	}

	public static void main(String[] args) {
//		getUsername();
//		System.out.println();
//		System.out.println(getNickname());
//		System.out.println(getAddress());
//		System.out.println(getPhone());
		System.out.println(getPostcode());
	}

}
