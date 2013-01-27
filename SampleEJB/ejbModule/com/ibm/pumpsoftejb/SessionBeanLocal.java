package com.ibm.pumpsoftejb;
import java.util.ArrayList;
import javax.ejb.Local;

import com.tivoli.pd.jras.pdjlog.jlog.NestedException;

@Local
public interface SessionBeanLocal {

	String getString();

	String readDB();

	ArrayList<String> getUserList();



}
