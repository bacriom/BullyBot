import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  questions: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('/questions').subscribe(data =>{
      this.questions = data;
    });
  }

}
