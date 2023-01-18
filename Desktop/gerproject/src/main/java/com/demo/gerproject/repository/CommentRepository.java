package com.demo.gerproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.gerproject.dao.UserCommentProjection;
import com.demo.gerproject.dao.UserCommentsResponse;
import com.demo.gerproject.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	@Query(value="SELECT p.name, c.text FROM comment as c inner join place as p on p.id = c.place_id where customer_id = :id", nativeQuery=true)
	List<UserCommentProjection> getUsersComments(int id);
	//With this query, we combine the tables from the database section and see which place and what comments the customer has made.
}
