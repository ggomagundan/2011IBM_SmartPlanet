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

import org.codehaus.jackson.annotate.JsonAnyGetter;

/**
 * Servlet implementation class UseItem
 */
@WebServlet("/UseItem")
public class UseItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/ItemBean",beanInterface=ItemBeanLocal.class)
	private ItemBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		int count = Integer.parseInt(request.getParameter("count"));
		String user_id = request.getParameter("user_id");
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		int point = Integer.parseInt(request.getParameter("point"));
		int user_plant_id = Integer.parseInt(request.getParameter("user_plant_id"));
		
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		int result = ejb3Session.useItem(count, user_id, item_id, point, user_plant_id);
		if(result != 0){
			j.put("result", true);
		}else {
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

