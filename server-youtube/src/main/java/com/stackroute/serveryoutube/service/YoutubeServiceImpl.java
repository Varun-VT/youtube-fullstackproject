package com.stackroute.serveryoutube.service;

import com.stackroute.serveryoutube.document.Video;
import com.stackroute.serveryoutube.exceptions.VideoAlreadyExistsException;
import com.stackroute.serveryoutube.exceptions.VideoNotFoundException;
import com.stackroute.serveryoutube.repository.YoutubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Profile("mongodb")
@Primary
//@Profile can be used to develop an “If-Then-Else” conditional checking to configure.
// mvn clean
// mvn spring-boot:run -Dspring.profiles.active=dummy
public class YoutubeServiceImpl implements YoutubeService {

    @Autowired // This means to get the bean called env
    // Which is auto-generated by Spring, we will use it to handle the data
    private Environment env;

    //    @Value("${trackRepository}")
    YoutubeRepository youtubeRepository;

    public void readProperty() {
        env.getProperty("trackRepository");
    }

    @PostConstruct
    private void init(){
        Video newvideo= new Video("ahd","hello","Yppy","ahgefd");
        youtubeRepository.save(newvideo);
    }


    //    At runtime spring'll provide this service a UserRepository object via constructor dependency injection
    @Autowired
    public YoutubeServiceImpl(YoutubeRepository youtubeRepository) {
        System.out.println("Inside notdummy");
        this.youtubeRepository = youtubeRepository;
    }

    @Override
    public Video saveVideo(Video video) throws VideoAlreadyExistsException{
// The save method comes from jpa repository inteface that our userRepository interface extends.
// Also, the actual implementation of save method'll be provided at runtime
        if (youtubeRepository.existsByVideourl(video.getVideourl())){
            throw new VideoAlreadyExistsException("Video Already exists");
        }
        Video savedVideo = youtubeRepository.save(video);

        return savedVideo;
    }

    @Override
    public List<Video> getAllVideos() {
        return youtubeRepository.findAll();
    }


    @Override
    public List<Video> deleteVideo(String url) throws VideoNotFoundException {
        if (youtubeRepository.existsByVideourl(url)) {
            youtubeRepository.deleteByVideourl(url);
            return youtubeRepository.findAll();
        }
        else {
            throw new VideoNotFoundException("Track not found Exception");
        }
    }

    @Override
    public List<Video> deleteAllVideos() {
        youtubeRepository.deleteAll();
        return youtubeRepository.findAll();
    }

}




