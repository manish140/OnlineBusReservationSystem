package com.capg.brs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.brs.entity.User;
@Service
@Transactional
public interface IUserService {
	public static final User UserDao = new User();
	public default User userLogin(int userId,String password)
	{
		if(UserDao.existById(userId))
		{
			User user=UserDao.getOne(userId);
			String pass=user.getPassword();
			if(pass.equals(password))
			{
				return user;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
}
