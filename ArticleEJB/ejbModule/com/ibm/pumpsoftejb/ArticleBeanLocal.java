package com.ibm.pumpsoftejb;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface ArticleBeanLocal {

	int countArticles();

	ArrayList<String> getArticleList(int start, int end);

	String getArticleContent(int id);

	ArrayList<String> getArticlePhoto(int id);

	ArrayList<String> getArticleComments(int id);

	int insertArticle(String id, String title, String article, String pic_name);

	int insertComment(String article_id, String user_id, String comment);

	int insertPhoto(String article_id, String url);

	int updateArticle(String title, String article, int article_id);

	int updateComment(String comment, int comment_id);

	String get(int start, int end);

	int updateRCO_Or_OC(int article_id, String user_id, int isRCOrOC);

	

	

}