package com.stackroute.serveryoutube.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("video")
public class Video {

    @Id
    private String videourl;
    private String title;
    private String channelTitle;
    private String viewCount;

    public Video() {
    }

    public Video(String videourl, String title, String channelTitle, String viewCount) {
        this.videourl = videourl;
        this.title = title;
        this.channelTitle = channelTitle;
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videourl='" + videourl + '\'' +
                ", title='" + title + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                ", viewCount='" + viewCount + '\'' +
                '}';
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }
}
