package com.et.lesson01.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.et.lesson01.entity.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbc;

	/* (non-Javadoc)
	 * @see com.et.lesson01.dao.imp.UserDao#addUser(int, java.lang.String, java.lang.String)
	 */
	public void addUser(int id, String name, String sex) {

		String sql = "insert into user(userId,userName,userSex) values(" + id
				+ "," + name + "," + sex + ")";
		System.out.println(sql);
		jdbc.execute(sql);
	}

	/* (non-Javadoc)
	 * @see com.et.lesson01.dao.imp.UserDao#deleteUser(int)
	 */
	public int deleteUser(int id) {
		String sql = "delete from user where 1 = 1 and userId=" + id;
		System.out.println(sql);

		jdbc.execute(sql);
		return id;
	}

	/* (non-Javadoc)
	 * @see com.et.lesson01.dao.imp.UserDao#updateUser(int, java.lang.String, java.lang.String)
	 */
	public int updateUser(int id, String name, String sex) {
		String sql = "update user set userName=" + name + ",userSex=" + sex
				+ " where userId=" + id;
		System.out.println(sql);
		jdbc.update(sql);
		return id;
	}

	/* (non-Javadoc)
	 * @see com.et.lesson01.dao.imp.UserDao#queryUser()
	 */
	public List<User> queryUser() {
		String sql = "select userId,userName,userSex from user;";
		List<User> lists = jdbc.query(sql, new MyRowMapper());
		return lists;

	}

}

class MyRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("userId");
		String name = rs.getString("userName");
		String sex = rs.getString("userSex");
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setSex(sex);
		return user;
	}
}
