package com.mh.demo.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.mh.demo.entity.Phone;

public class PhoneList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Phone> listPhone = this.preparePhoneList();
		ObjectMapper objectMapper = new ObjectMapper();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf=8");
		OutputStream out = resp.getOutputStream();
		objectMapper.writeValue(out, listPhone);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	private List<Phone> preparePhoneList() {
		List<Phone> listPhone = new ArrayList<Phone>();
		Phone phone = null;
		for (int i=0;i<20;i++) {
			phone = new Phone();
			phone.setAge(i+1);
			phone.setName("phone name " + i);
			phone.setId("phone id " + i);
			phone.setSnippet("phone snippet " + i);
			phone.setImageUrl("images/phone/"+i+".jpg");
			listPhone.add(phone);
		}
		return listPhone;
	}
	

}
