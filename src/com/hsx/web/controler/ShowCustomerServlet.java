package com.hsx.web.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsx.domain.Customer;
import com.hsx.domain.Page;
import com.hsx.service.CustomerService;
import com.hsx.service.impl.CustomerServiceImpl;

/**
 * 查询出所有的客户，并转向客户显示的页面
 * @author hsx
 *
 */
public class ShowCustomerServlet extends HttpServlet {
	
	private CustomerService customerService = new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//List<Customer> list = customerService.queryAllCustomer();
		
		// 查看有没有pageNum参数
		String pageNum = request.getParameter("pageNum");
		Page page = customerService.getPageData(pageNum);
		page.setServletName(getServletName());
		//request.setAttribute("customers", page.getList());
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/pages/listCustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
