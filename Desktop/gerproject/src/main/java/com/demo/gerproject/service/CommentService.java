package com.demo.gerproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.gerproject.model.Comment;
import com.demo.gerproject.model.Customer;
import com.demo.gerproject.repository.CommentRepository;
import com.demo.gerproject.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;

	public List<Comment> getComments() {
		return commentRepository.findAll();
	}

	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public void deleteComment(int id) {
		commentRepository.deleteById(id);
	}

	public Comment getCommentById(int id) {
		return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment is not found!"));
	}
}
