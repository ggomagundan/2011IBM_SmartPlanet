package com.ibm.pumpsoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class InsertItem
 */
@WebServlet("/InsertItem")
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/ItemBean",beanInterface=ItemBeanLocal.class)
	private ItemBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		String url = request.getParameter("url");
		int count = Integer.parseInt(request.getParameter("count"));
		
		
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		int result = ejb3Session.insertItem(name, description, price, url, count);
		if(result == 1){
			j.put("result", true);
		}else{
			j.put("result", false);
		}
		json.add(j);
		JSONObject js =  new JSONObject();
		
		js.put("data", json);
		
		out.println(js);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
