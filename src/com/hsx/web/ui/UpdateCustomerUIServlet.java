package com.hsx.web.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsx.domain.Customer;
import com.hsx.service.CustomerService;
import com.hsx.service.impl.CustomerServiceImpl;
import com.hsx.util.Hobby;

/**
 * 转发到修改客户的页面
 * @author hsx
 *
 */
public class UpdateCustomerUIServlet extends HttpServlet {

	private CustomerService customerService = new CustomerServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Customer customer = customerService.queryCustomerById(id);
		// 放爱好备选项
		request.setAttribute("hobby", Hobby.getHobbies());
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/pages/updateCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
