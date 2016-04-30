package com.hsx.service;

import java.util.List;

import com.hsx.domain.Customer;
import com.hsx.domain.Page;

/**
 * CustomerService接口
 * @author hsx
 *
 */
public interface CustomerService {

	/**
	 * 查询所有的客户
	 * @return
	 */
	public List<Customer> queryAllCustomer();
	
	/**
	 * 根据客户的ID查询客户
	 * @param customerId
	 * @return
	 */
	public Customer queryCustomerById(String customerId);
	
	/**
	 * 修改客户信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 根据客户的ID删除客户
	 * @param customerId
	 */
	public void deleteCustomer(String customerId);
	
	/**
	 * 添加客户
	 * @param customer
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * 分页
	 * @param pageNum
	 * @return
	 */
	public Page getPageData(String pageNum);
	
}
