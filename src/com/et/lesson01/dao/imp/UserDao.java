package com.et.lesson01.dao.imp;

import java.util.List;

import com.et.lesson01.entity.User;

public interface UserDao {

	public abstract void addUser(int id, String name, String sex);

	public abstract int deleteUser(int id);

	public abstract int updateUser(int id, String name, String sex);

	public abstract List<User> queryUser();

}