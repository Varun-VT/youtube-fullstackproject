import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

import { IVideo } from './video';


@Injectable({
  providedIn: 'root'
})
export class ServerService {

  constructor(private http: HttpClient, private response: HttpResponse<any>) { }

  saveToDatabase(_videourl: string, _title: string, _channelTitle: string ,_viewCount: string){
    //save data to database using api
    let data= {"videourl": _videourl, "title": _title, "channelTitle": _channelTitle, "viewCount": _viewCount};
    console.log("in service :",(data));
        let demo;
    let url= "http://localhost:8082/api/favourites/save";
    // return this.http.post(url,JSON.stringify(data)).
    // subscribe(data=>{demo=data})
    return this.http.post(url,
        data, {headers: {'Content-Type': 'application/json'}})
        .subscribe(data=>{demo=data});
  };
 
  getFavourites(): Observable<IVideo[]>{
    
    let url= "http://localhost:8082/api/favourites/getallfavourites";
    console.log("In-get-favourites");
    return this.http.get(url).source(response => console.log(this.response.body()))
    return this.response..body({responseType: 'text'});
    // .pipe(catchError((err: HttpErrorResponse)=>{
    //         return throwError(err.message);
  }

}