package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource
    private UserMapper userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

	@Override
	public List<User> getUserListByPages(Integer beginNum,Integer endNum) {
		// TODO Auto-generated method stub
		return this.userDao.getUsersListByPages(beginNum, endNum);
	}

	@Override
	public List<User> getUserListTop100() {
		
		List<User> list=this.userDao.getUsersList();
		for (User user : list) {
			System.out.println(user);
		}
		List<User> userList=new ArrayList<User>();
		for (User user : list) {
			
			if(user.getSex()!=null && user.getSex().equals("1")){
				user.setSex("男");
			}else if(user.getSex()!=null && user.getSex().equals("0")){
				user.setSex("女");
			}
			
			userList.add(user);
		}
		
		return userList;
		
		
	}
}
