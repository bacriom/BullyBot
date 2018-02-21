import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {

  answers: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('/answers').subscribe(data =>{
      this.answers = data;
    });
  }

}
