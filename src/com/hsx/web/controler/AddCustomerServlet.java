package com.hsx.web.controler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.hsx.domain.Customer;
import com.hsx.service.CustomerService;
import com.hsx.service.impl.CustomerServiceImpl;
import com.hsx.util.WebUtil;
import com.hsx.web.formbean.CustomerFormBean;

/**
 * 保存用户
 * @author hsx
 *
 */
public class AddCustomerServlet extends HttpServlet {

	private CustomerService customerService = new CustomerServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//中文编码问题
			request.setCharacterEncoding("UTF-8");
			// 封装数据
			CustomerFormBean customerFormBean = WebUtil.request2FormBean(request, CustomerFormBean.class);
			// 填充模型
			Customer customer = new Customer();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(customer, customerFormBean);
			// 单独处理hobby
			String[] hobbies = customerFormBean.getHobbies();
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < hobbies.length; i++) {
				if (i > 0) {
					stringBuffer.append(",");
				}
				stringBuffer.append(hobbies[i]);
			}
			customer.setHobby(stringBuffer.toString());
			customerService.addCustomer(customer);
			// 提示成功
			request.setAttribute("message", "添加成功！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			// 提示失败
			request.setAttribute("message", "添加失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
