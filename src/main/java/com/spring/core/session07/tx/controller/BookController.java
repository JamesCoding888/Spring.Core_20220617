package com.spring.core.session07.tx.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.spring.core.session07.tx.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	public void buyBook(Integer wid, Integer bid) {
		// will do it on Monday
	}
	
	public void buyMany(Integer wid, Integer ... bids) {
		// will do it on Monday
	}
	
}
