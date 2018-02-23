import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-answers',
  templateUrl: './answers.component.html',
  styleUrls: ['./answers.component.css']
})
export class AnswersComponent implements OnInit {
  answers: any

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.getAnswers(this.route.snapshot.params['id']);


  }

  getAnswers(id) {
    this.http.get('/answers/'+id).subscribe(data => {
      this.answers = data;
    });
  }
}
