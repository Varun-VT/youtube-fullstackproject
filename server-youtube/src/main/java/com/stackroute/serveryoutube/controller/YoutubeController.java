package com.stackroute.serveryoutube.controller;

import java.util.List;

import com.stackroute.serveryoutube.document.Video;
import com.stackroute.serveryoutube.exceptions.VideoAlreadyExistsException;
import com.stackroute.serveryoutube.exceptions.VideoNotFoundException;
import com.stackroute.serveryoutube.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/favourites")
//@CrossOrigin(origins = "*", allowedHeaders = "*",value = "localhost:4200")
@CrossOrigin(origins = "http://localhost:4200")
public class YoutubeController {


    private YoutubeService youtubeService;

    @Autowired
    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService= youtubeService;
    }

    @GetMapping("/getallfavourites")
    public List<Video> getFavourites() {
        return youtubeService.getAllVideos();
    }

    @PostMapping("/save")
    public Video saveVideo(@RequestBody Video video)
    {

        try{
           video= youtubeService.saveVideo(video);
        }
        catch (VideoAlreadyExistsException e) { }
        return video;
    }

    @RequestMapping(value = "/{url}", method = RequestMethod.DELETE)
    public List<Video> deleteVideo(@PathVariable String url) {
        try {
            youtubeService.deleteVideo(url);
        } catch (VideoNotFoundException e) {
            e.printStackTrace();
        }
        return youtubeService.getAllVideos();
    }

    @DeleteMapping("/deleteallvideos")
    public List<Video> deleteAllVideos() {
        ResponseEntity responseEntity;
        try {
            youtubeService.deleteAllVideos();
        }
        catch (Exception e){ }
        return youtubeService.getAllVideos();
    }
}