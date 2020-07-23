package com.example.ming.imp;

import com.example.ming.domain.Student;
import com.example.ming.i.StudentService;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(serviceName = "StudentService", // 对外发布的服务名
		targetNamespace = "http://demo.student.com/", // 指定你想要的名称空间，通常使用使用包名反转
		endpointInterface = "com.example.ming.i.StudentService") // 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class StudentServiceImpl implements StudentService {

	private Map<String, Student> studentMap = new HashMap<String, Student>();

	public StudentServiceImpl() {
		Student student1 = new Student();
		student1.setAge(19);
		student1.setDate(new Date());
		student1.setName("student1");
		studentMap.put(student1.getName(), student1);

		Student student2 = new Student();
		student2.setAge(7);
		student2.setDate(new Date());
		student2.setName("student2");
		studentMap.put(student2.getName(), student2);
	}

	@Override
	public Student getStudent(String name) {
		return studentMap.get(name);
	}
	
	@Override
	public String getStudentInfo(Student student) {
		return student.toString();
	}
}
