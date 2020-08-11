package com.org.RecapSpringBoot.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	private static List<User> users=new ArrayList<>();
	private static int id=3;
	static {
		users.add(new User(1,"Bhaskar",new Date()));
		users.add(new User(2,"Abhishek",new Date()));
		users.add(new User(3,"Kaustav",new Date()));
	}
	
	public List<User> findAll()	{
		return users;
	}  
	
	public User save(User user)	{
		if(user.getId()==null)
		{
			user.setId(++id);
		}
		users.add(user);
		return user;
	} 
	
	public User findUser(int id)	{
		for(User u :users){
			if(u.getId()==id){
				return u;
			}
		}
		return null;
	}
	
	public User deleteUserById(int id)	{
		Iterator<User> itr=users.iterator();
		while(itr.hasNext())
		{
		   User u =itr.next();
		   if(u.getId()==id){
			  itr.remove();
			  return u;
			}
		}
		return null;
	}
	
}
