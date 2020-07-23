package com.example.ming.imp;

import com.example.ming.domain.Book;
import com.example.ming.i.BookService;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(serviceName = "BookService", // 对外发布的服务名
		targetNamespace = "http://demo.example.cn/", // 指定你想要的名称空间，通常使用使用包名反转
		endpointInterface = "com.example.ming.i.BookService") // 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class BookServiceImpl implements BookService {

	private Map<String, Book> bookMap = new HashMap<String, Book>();

	public BookServiceImpl() {
		Book book1 = new Book();
		book1.setDate(new Date());
		book1.setName("book1");
		bookMap.put(book1.getName(), book1);

		Book book2 = new Book();
		book2.setDate(new Date());
		book2.setName("book2");
		bookMap.put(book2.getName(), book2);
	}

	@Override
	public Book getBook(String name) {
		return bookMap.get(name);
	}
	
	@Override
	public String getBookInfo(Book book) {
		return book.toString();
	}
}
