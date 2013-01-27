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
 * Servlet implementation class ArticleContent
 */
@WebServlet("/ArticleContent")
public class ArticleContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="ejb/ArticleBean",beanInterface=ArticleBeanLocal.class)
	private ArticleBeanLocal ejb3Session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int articleID = Integer.parseInt(request.getParameter("id"));
		String content = ejb3Session.getArticleContent(articleID);
		
		PrintWriter out = response.getWriter();
		
		JSONArray json = new JSONArray();
		JSONObject j = new JSONObject();
		j.put("content", content);
		
		//out.println("content is " + content);
		JSONObject js =  new JSONObject();
		json.add(j);
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
