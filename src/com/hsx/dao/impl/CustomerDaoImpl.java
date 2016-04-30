package com.hsx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hsx.dao.CustomerDao;
import com.hsx.domain.Customer;
import com.hsx.exception.DaoException;
import com.hsx.exception.IdIsNullException;
import com.hsx.util.JDBCUtil;

/**
 * CustomerDao接口的实现类
 * 
 * @author hsx
 * 
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into customer values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getGender());
			preparedStatement.setDate(4, new java.sql.Date(customer.getBirthday().getTime()));
			preparedStatement.setString(5, customer.getCellphone());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setString(7, customer.getHobby());
			preparedStatement.setString(8, customer.getType());
			preparedStatement.setString(9, customer.getDescription());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public void deleteCustomer(String customerId) throws IdIsNullException {
		if (customerId == null || customerId.trim().equals("")) {
			throw new IdIsNullException();
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "delete from customer where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws IdIsNullException {
		if (customer.getId() == null || customer.getId().trim().equals("")) {
			throw new IdIsNullException();
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "update customer set name = ?, gender = ?, birthday = ?, cellphone = ?, email = ?, hobby = ?, type = ?, description = ? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setDate(3, new java.sql.Date(customer.getBirthday().getTime()));
			preparedStatement.setString(4, customer.getCellphone());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getHobby());
			preparedStatement.setString(7, customer.getType());
			preparedStatement.setString(8, customer.getDescription());
			preparedStatement.setString(9, customer.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public List<Customer> queryAllCustomer() {
		List<Customer> list = new ArrayList<Customer>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from customer";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setBirthday(resultSet.getDate("birthday"));
				customer.setCellphone(resultSet.getString("cellphone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setHobby(resultSet.getString("hobby"));
				customer.setType(resultSet.getString("type"));
				customer.setDescription(resultSet.getString("description"));
				list.add(customer);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
		return list;
	}

	@Override
	public Customer queryCustomerById(String customerId)
			throws IdIsNullException {
		if (customerId == null || customerId.trim().equals("")) {
			throw new IdIsNullException();
		}
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from customer where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setBirthday(resultSet.getDate("birthday"));
				customer.setCellphone(resultSet.getString("cellphone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setHobby(resultSet.getString("hobby"));
				customer.setType(resultSet.getString("type"));
				customer.setDescription(resultSet.getString("description"));
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
		return customer;
	}

	@Override
	public int getRecordsNum() {
		int num = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select count(*) from customer";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				num = resultSet.getInt(1);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
		return num;
	}

	@Override
	public List<Customer> getPageData(int startIndex, int pageSize) {
		List<Customer> list = new ArrayList<Customer>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from customer limit ?, ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startIndex);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setBirthday(resultSet.getDate("birthday"));
				customer.setCellphone(resultSet.getString("cellphone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setHobby(resultSet.getString("hobby"));
				customer.setType(resultSet.getString("type"));
				customer.setDescription(resultSet.getString("description"));
				list.add(customer);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JDBCUtil.release(resultSet, preparedStatement, connection);
		}
		return list;
	}

}
