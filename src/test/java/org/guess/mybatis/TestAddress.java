package org.guess.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.guess.mybatis.bean.Address;
import org.guess.mybatis.bean.User;
import org.guess.mybatis.util.RandomUtil;
import org.junit.Test;

public class TestAddress {

	private static SqlSessionFactory factory = null;
	
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-configs.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd(){
		SqlSession session = factory.openSession();
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("pageOffset", 0);
		params.put("pageSize", 100);
		List<User> list = session.selectList(User.class.getName()+".find", params);
//		System.out.println(list.size());
//		for (User user:list) {
//			System.out.println(user.getNickname()+"  "+user.getId());
//		}
		for (int i = 0; i < 100; i++) {
			int r = (int)(Math.random()*100);
			Address address = new Address();
			address.setName(RandomUtil.getAddress());
			address.setPhone(RandomUtil.getPhone());
			address.setPostcode(RandomUtil.getPostcode());
			address.setUser(list.get(r));
			session.insert(Address.class.getName()+".add", address);
			System.out.println(i+"    "+r);
		}
		session.commit();
		session.close();
	}
	
	@Test
	public void testUpdate(){
		SqlSession session = factory.openSession();
		User user = new User();
		user.setNickname("张三");
		user.setPassword("123456");
		user.setUsername("nihao");
		user.setType(1);
		user.setId(2);
//		session.insert("org.guess.mybatis.bean.User.update", user);
		session.update("org.guess.mybatis.bean.User.update", user);
		session.commit();
		session.close();
	}
	
	@Test
	public void testDelete(){
		SqlSession session = factory.openSession();
		session.delete("org.guess.mybatis.bean.Address.delete", 308);
		session.commit();
		session.close();
		System.out.println("success");
	}
	
	@Test
	public void testList(){
		SqlSession session = factory.openSession();
		List<Address> list = session.selectList(Address.class.getName()+".list");
		session.commit();
		session.close();
		for(Address address:list){
			System.out.println(address.getUser().getNickname());
		}
	}
	
	@Test
	public void testLoad(){
		SqlSession session = factory.openSession();
		Address address = session.selectOne(Address.class.getName()+".load", 3);
		session.commit();
		session.close();
		System.out.println(address.getUser().getNickname());
	}
	
	@Test
	public void testFindCount(){
		SqlSession session = factory.openSession();
		int totalCount = session.selectOne(User.class.getName()+".find_count", null);
		System.out.println(totalCount);
	}
	
	@Test
	public void testFind(){
		SqlSession session = factory.openSession();
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("pageOffset", 0);
		params.put("pageSize", 50);
		List<Address> list = session.selectList(Address.class.getName()+".find", params);
		System.out.println(list.size());
		for(Address address:list){
			System.out.println(address.getUser().getNickname());
		}
	}

	public static void main(String[] args) {

		new TestAddress().testList();
	}

}
