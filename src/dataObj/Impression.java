package dataObj;

import java.io.Serializable;

public class Impression implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer book_id;
	public Impression(Integer id, String name, Integer book_id) {
		this.id = id;
		this.name = name;
		this.book_id = book_id;
	}
	public Impression() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	
}
