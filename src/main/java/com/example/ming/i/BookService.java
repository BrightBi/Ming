package com.example.ming.i;

import com.example.ming.domain.Book;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://demo.example.cn/")
public interface BookService {
	@WebMethod
    public Book getBook(@WebParam(name = "name") String name);

    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public String getBookInfo(@WebParam(name = "book") Book book);
}
