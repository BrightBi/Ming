package com.example.ming.domain;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	private static final long serialVersionUID = 5415785613034348067L;
	private String name;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", date=" + date + "]";
	}
}
