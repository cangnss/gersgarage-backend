package com.demo.gerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
