package com.hsx.dao;

import java.util.List;

import com.hsx.domain.Customer;
import com.hsx.exception.IdIsNullException;

/**
 * CustomerDao层接口
 * @author hsx
 *
 */
public interface CustomerDao {
	
	/**
	 * 添加新客户
	 * @param customer
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * 删除客户
	 * @param customerId
	 * @throws IdIsNullException 如果参数为null或"",抛出异常
	 */
	public void deleteCustomer(String customerId) throws IdIsNullException;
	
	/**
	 * 修改客户信息
	 * @param customer
	 * @throws IdIsNullException 如果参数为null或"",抛出异常
	 */
	public void updateCustomer(Customer customer) throws IdIsNullException;
	
	/**
	 * 查询所有的客户
	 * @return
	 */
	public List<Customer> queryAllCustomer();
	
	/**
	 * 根据Id查询客户信息
	 * @param customerId
	 * @return
	 * @throws IdIsNullException
	 */
	public Customer queryCustomerById(String customerId) throws IdIsNullException;
	
	/**
	 * 查询记录总数，多少个客户
	 * @return
	 */
	public int getRecordsNum();
	
	/**
	 * 取分页数据
	 * @param startIndex - 起始记录的索引，从0开始
	 * @param pageSize - 每页显示多少条
	 * @return
	 */
	public List<Customer> getPageData(int startIndex, int pageSize);
}
