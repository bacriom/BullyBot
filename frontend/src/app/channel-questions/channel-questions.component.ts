import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-channel-questions',
  templateUrl: './channel-questions.component.html',
  styleUrls: ['./channel-questions.component.css']
})
export class ChannelQuestionsComponent implements OnInit {

  channel: {}

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.getChannelQuestions(this.route.snapshot.params['id']);


}

  getChannelQuestions(id) {
    this.http.get('/questions/' + id).subscribe(data => {
      this.channel = data;
    });
  }
  }

