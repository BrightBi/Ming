package com.example.ming.i;

import com.example.ming.domain.Student;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://demo.student.com/")
public interface StudentService {
	@WebMethod
    public Student getStudent(@WebParam(name = "name") String name);

    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public String getStudentInfo(@WebParam(name = "book") Student student);
}
