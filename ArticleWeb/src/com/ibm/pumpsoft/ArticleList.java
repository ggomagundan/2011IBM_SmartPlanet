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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ibm.pumpsoftejb.ArticleBeanLocal;

/**
 * Servlet implementation class ArticleList
 */
@WebServlet("/ArticleList")
public class ArticleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name="ejb/ArticleBean",beanInterface=ArticleBeanLocal.class)
	private ArticleBeanLocal ejb3Session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int start, end;
		start = Integer.parseInt(request.getParameter("start"));
		end = Integer.parseInt(request.getParameter("end"));
		
		ArrayList<String> list =  ejb3Session.getArticleList(start, end);
		//String lists = ejb3Session.get(start, end);
		PrintWriter out = response.getWriter();
		
		JSONArray json = new JSONArray();
		
		
	
		
		for(String users : list){
			
			String[] article = users.split("!PuMp!");
			
			JSONObject j = new JSONObject();
		
			j.put("article_id", article[0]);
			j.put("user_id",article[1]);
			j.put("nickname",article[2]);
			j.put("title",article[3]);
			j.put("time", article[4]);
			j.put("rc", article[5]);
			j.put("oc", article[6]);
			j.put("type", article[7]);
			j.put("m_name",article[8]);
			j.put("rownum", article[9]);
			json.add(j);
			
			
			
			
		/*	
			out.print("id : " + article[0]);
			out.print("  user_id : " + article[1]);
			out.print("  title : " + article[2]);
			out.print("  time : " + article[3]);
			out.println("  rc : " + article[4]);
			out.println("  oc : " + article[5]);
			out.println("  rownum : " + article[6]);
			
		*/	
			
		}
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("data", json);
		out.println(jsonobj.toString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
