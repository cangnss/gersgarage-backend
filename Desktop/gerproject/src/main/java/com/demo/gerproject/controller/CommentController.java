package com.demo.gerproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gerproject.model.Comment;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.service.CommentService;
import com.demo.gerproject.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
	private final CommentService commentService;

	@GetMapping
	public ResponseEntity<List<Comment>> getComments() {
		return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable int id) {
		return new ResponseEntity<>(getCommentById(id), HttpStatus.OK);
	}

	private Comment getCommentById(int id) {
		return commentService.getCommentById(id);
	}

	@PostMapping
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
		return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> getComment(@PathVariable int id, @RequestBody Comment comment) {
		Comment oldComment = getCommentById(id);
		oldComment.setText(comment.getText());
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable int id) {
		commentService.deleteComment(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
