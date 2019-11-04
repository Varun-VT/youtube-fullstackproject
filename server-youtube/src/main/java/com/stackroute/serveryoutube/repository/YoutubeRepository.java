package com.stackroute.serveryoutube.repository;

import com.stackroute.serveryoutube.document.Video;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface YoutubeRepository extends MongoRepository<Video, String>{

    int deleteByVideourl(String videourl);
    boolean existsByVideourl(String videourl);
}
