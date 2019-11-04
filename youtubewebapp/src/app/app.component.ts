import { Component } from '@angular/core';
import { ServerService } from './video.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'twitterwebapp';

  constructor(private serverservice: ServerService) { }

  showFavourites(){
    this.serverservice.getFavourites()
  }
}
