import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-channel',
  templateUrl: './channel.component.html',
  styleUrls: ['./channel.component.css']
})
export class ChannelComponent implements OnInit {

  channels: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('/channels').subscribe(data =>{
      this.channels = data;
    });
  }

}
