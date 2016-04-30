package com.hsx.web.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsx.service.CustomerService;
import com.hsx.service.impl.CustomerServiceImpl;

/**
 * 删除客户的Servlet
 * @author hsx
 *
 */
public class DeleteCustomerServlet extends HttpServlet {
	
	private CustomerService customerService = new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String[] ids = request.getParameterValues("ids");
			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					customerService.deleteCustomer(id);
				}
				request.setAttribute("message", "删除成功！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "删除失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
