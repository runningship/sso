package com.test.dubbo;

import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.common.json.JSONObject;

public interface IDemoService {
	String sayHello(String name);  
	  
    public List getUsers(); 
    
    public Object call(String method , Map param);
}
