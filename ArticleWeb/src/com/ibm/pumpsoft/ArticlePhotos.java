package com.ibm.pumpsoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.pumpsoftejb.ArticleBeanLocal;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ArticlePhotos
 */
@WebServlet("/ArticlePhotos")
public class ArticlePhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/ArticleBean",beanInterface=ArticleBeanLocal.class)
	private ArticleBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticlePhotos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id;
		id = Integer.parseInt(request.getParameter("id"));
		
		
		ArrayList<String> list =  ejb3Session.getArticlePhoto(id);
		
		PrintWriter out = response.getWriter();
		
		JSONArray json = new JSONArray();
		
		for(String users : list){
			
			String[] photo = users.split("!PuMp!");
			JSONObject j = new JSONObject();
			j.put("url", photo[0]);
			json.add(j);
			
			
		//	out.print("url : " + photo[0]);
			
			
			
			
		}
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
