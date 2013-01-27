package com.ibm.pumpsoftejb;
import com.tivoli.pd.jras.pdjlog.jlog.NestedException;
import javax.ejb.Local;

@Local
public interface JSONBeanLocal {

	String getJson();

}
