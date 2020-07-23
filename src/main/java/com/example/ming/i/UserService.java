package com.example.ming.i;

import com.example.ming.domain.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://demo.example.com/")
public interface UserService {
	@WebMethod
    public User getUser(@WebParam(name = "userId") String userId);

    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public String getUserName(@WebParam(name = "userId") String userId);
    
    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public String getUserInfo(@WebParam(name = "user") User user);
}
