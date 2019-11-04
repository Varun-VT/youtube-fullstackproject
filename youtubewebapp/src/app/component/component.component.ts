import { Component, OnInit } from '@angular/core';
import { YoutubeService } from '../youtube.service';
import { ServerService } from '../video.service'
import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Pipe({
  name: 'safe'
})

@Component({
  selector: 'component',
  templateUrl: './component.component.html',
  styleUrls: ['./component.component.css']
})

export class ComponentComponent implements OnInit, PipeTransform {

  youtubeUrl = 'https://www.youtube.com/watch?v=iHhcHTlGtRs';

  tracks = []
  constructor(private service: YoutubeService, private sanitizer: DomSanitizer, private serverservice: ServerService) { 
    //We creates a service instance of YoutubeService to fetch our data
  }
  
  transform(url) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }

  ngOnInit() {
    console.log(this.service.letsCreateAnotherMethod());

    // For fetching the data, code goes here
    this.service.getTracks().subscribe((data: any) => {
      this.tracks = data.items;
    })
  }
  
  saveToDatabase(videourl: string, title: string, channelTitle: string ,viewCount: string) {
    
    this.serverservice.saveToDatabase(videourl, title, channelTitle ,viewCount)

  }

}
