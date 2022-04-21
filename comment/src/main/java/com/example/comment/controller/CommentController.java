package com.example.comment.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comment.entity.ProductCommentDto;
import com.example.comment.service.CommentService;

@RestController
@RequestMapping("comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping("{prodId}")
	public ProductCommentDto getRating(@PathVariable int prodId) throws InterruptedException {
		int nextInt = ThreadLocalRandom.current().nextInt(10, 5000);
		Thread.sleep(nextInt);
		System.out.println("Comment service latency:" + nextInt);
		return this.commentService.getReviewForProduct(prodId);
	}

	@PutMapping("{prodId}")
	public void putComment(@PathVariable int prodId) throws RuntimeException {
		this.commentService.putComment(prodId);
	}

}
