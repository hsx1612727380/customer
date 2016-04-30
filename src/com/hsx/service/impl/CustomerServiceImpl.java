package com.hsx.service.impl;

import java.util.List;

import com.hsx.dao.CustomerDao;
import com.hsx.dao.impl.CustomerDaoImpl;
import com.hsx.domain.Customer;
import com.hsx.domain.Page;
import com.hsx.exception.IdIsNullException;
import com.hsx.service.CustomerService;
import com.hsx.util.IdGenerator;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public List<Customer> queryAllCustomer() {
		return customerDao.queryAllCustomer();
	}

	@Override
	public Customer queryCustomerById(String customerId) {
		Customer customer = null;
		try {
			customer = customerDao.queryCustomerById(customerId);
		} catch (IdIsNullException e) {
			throw new RuntimeException("ID不能为空");
		}
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			customerDao.updateCustomer(customer);
		} catch (IdIsNullException e) {
			throw new RuntimeException("ID不能为空");
		}
	}

	@Override
	public void deleteCustomer(String customerId) {
		try {
			customerDao.deleteCustomer(customerId);
		} catch (IdIsNullException e) {
			throw new RuntimeException("ID不能为空");
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		// 设置ID
		customer.setId(IdGenerator.getId());
		// 存储
		customerDao.addCustomer(customer);
	}

	@Override
	public Page getPageData(String pageNum) {
		int totalRecord = customerDao.getRecordsNum();
		if (pageNum == null) {
			// 第一页
			Page page = new Page(totalRecord, 1);
			List<Customer> list = customerDao.getPageData(page.getStartIndex(), page.getPageSize());
			page.setList(list);
			return page;
		}
		else {
			int num = Integer.parseInt(pageNum);
			Page page = new Page(totalRecord, num);
			List<Customer> list = customerDao.getPageData(page.getStartIndex(), page.getPageSize());
			page.setList(list);
			return page;
		}
	}
	
}
