package com.ibm.pumpsoftejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ibm.json.java.*;

/**
 * Session Bean implementation class JSONBean
 */
@Stateless
@LocalBean
public class JSONBean implements JSONBeanLocal, Serializable {

    /**
     * Default constructor. 
     */
    public JSONBean() {
        // TODO Auto-generated constructor stub
    }
    
 public String getJson() {
    	
    	// Using Getting JSON Data
	 	// To Make Source
    	return "sdfsdf";
    }

}
