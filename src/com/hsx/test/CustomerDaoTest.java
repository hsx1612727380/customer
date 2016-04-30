package com.hsx.test;


import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hsx.dao.CustomerDao;
import com.hsx.dao.impl.CustomerDaoImpl;
import com.hsx.domain.Customer;
import com.hsx.exception.IdIsNullException;

public class CustomerDaoTest {
	
	private CustomerDao customerDao = new CustomerDaoImpl();

	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setId("1");
		customer.setName("小山");
		customer.setGender("1");
		customer.setBirthday(new Date());
		customer.setCellphone("120");
		customer.setEmail("xiaosan@126.com");
		customer.setHobby("篮球，乒乓球");
		customer.setDescription("学生");
		customer.setType("2");
		customerDao.addCustomer(customer);
	}

	public void testDeleteCustomer() throws IdIsNullException {
		customerDao.deleteCustomer("2");
	}

	public void testUpdateCustomer() throws IdIsNullException {
		Customer customer = new Customer();
		customer.setId("1");
		customer.setGender("0");
		customer.setBirthday(new Date());
		customerDao.updateCustomer(customer);
	}

	public void testQueryAllCustomer() {
		List<Customer> list = customerDao.queryAllCustomer();
		Assert.assertEquals(1, list.size());

	}

	public void testQueryCustomerById() throws IdIsNullException {
		Customer customer = customerDao.queryCustomerById("1");
		Assert.assertNotNull(customer);
	}
	
	@Test
	public void testgetRecordsNum() {
		int num = customerDao.getRecordsNum();
		Assert.assertEquals(16, num);
	}

	@Test
	public void testgetPageData() {
		List<Customer> list = customerDao.getPageData(10, 1);
		Assert.assertEquals(1, list.size());
	}
}
