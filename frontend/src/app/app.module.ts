import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ChannelComponent } from './channel/channel.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AnswerComponent } from './answer/answer.component';
import { QuestionComponent } from './question/question.component';

const appRoutes: Routes = [
  {
    path: 'channel',
    component: ChannelComponent,
    data: { title: 'Channel List' }
  },
  {
    path: 'answer',
    component: AnswerComponent,
    data: { title: 'Answer List' }
  },
  {
    path: 'question',
    component: QuestionComponent,
    data: { title: 'Questions List'}
  },
  { path: '',
    redirectTo: '/question',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ChannelComponent,
    AnswerComponent,
    QuestionComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
      )// <-- debugging purposes only
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
