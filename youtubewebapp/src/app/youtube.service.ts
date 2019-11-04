import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  constructor(private _:HttpClient) { 
    //   Here httpclient dependency is declared in our constructor
  }

  letsCreateAnotherMethod() {
    console.log("check !!!")
  }
  getTracks() {
    return this._.get('https://www.googleapis.com/youtube/v3/videos?part=snippet,contentDetails,statistics,status&chart=mostPopular&regionCode=IN&maxResults=25&key=AIzaSyArOT6Yw0bMHqKoOHyUzd8wWOfk_1MmW2U')
  }
}