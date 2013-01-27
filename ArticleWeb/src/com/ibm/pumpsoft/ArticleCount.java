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

import com.ibm.pumpsoftejb.ArticleBeanLocal;



/**
 * Servlet implementation class ArticleCount
 */
@WebServlet("/ArticleCount")
public class ArticleCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name="ejb/ArticleBean",beanInterface=ArticleBeanLocal.class)
	private ArticleBeanLocal ejb3Session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int count = ejb3Session.countArticles();
		PrintWriter out = response.getWriter();
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		j.put("count",count);
		//out.println(count +"Articles's Having");
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
