package com.mh.demo.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.mh.demo.entity.Phone;

public class PhoneDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phoneId = req.getParameter("phoneId");
		System.out.println(phoneId);
		Phone phone = getPhoneById(phoneId);
		resp.setContentType("application/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		OutputStream out = resp.getOutputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(out, phone);
		out.flush();
		out.close();
	}

	private Phone getPhoneById(String phoneId) {
		Phone phone = new Phone();
		phone.setAge(1);
		phone.setName("iPhone6");
		phone.setId("iPhone6");
		phone.setSnippet("iPhone6 Plus");
		phone.setImageUrl("images/phone/1.jpg");
		return phone;
	}

}
