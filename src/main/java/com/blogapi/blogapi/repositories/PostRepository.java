package com.blogapi.blogapi.repositories;

import java.util.List;

import com.blogapi.blogapi.models.PostModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <PostModel, Integer>{
    public List<PostModel> findAllByOrderByCreatedAtDesc();

    @Query("select p from PostModel p where p.title like %?1%")
	List<PostModel> findByTitleLike(String title);
}
