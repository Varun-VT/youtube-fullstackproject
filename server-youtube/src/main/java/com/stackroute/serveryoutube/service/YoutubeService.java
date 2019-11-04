package com.stackroute.serveryoutube.service;

import com.stackroute.serveryoutube.document.Video;
import com.stackroute.serveryoutube.exceptions.VideoAlreadyExistsException;
import com.stackroute.serveryoutube.exceptions.VideoNotFoundException;

import java.util.List;

public interface YoutubeService {

    public Video saveVideo(Video video) throws VideoAlreadyExistsException;

    public List<Video> getAllVideos();

    public List<Video> deleteVideo(String url) throws VideoNotFoundException;

    public List<Video> deleteAllVideos();

}

