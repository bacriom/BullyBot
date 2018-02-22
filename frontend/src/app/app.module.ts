import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ChannelComponent } from './channel/channel.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AnswerComponent } from './answer/answer.component';
import { QuestionComponent } from './question/question.component';
import { HomeComponent } from './home/home.component';
import { ChannelQuestionsComponent } from './channel-questions/channel-questions.component';

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
  {
    path: 'channel-questions/:id',
    component: ChannelQuestionsComponent,
    data: {title: 'Channel Questions'}
  },
  {
    path: 'home',
    component: HomeComponent,
    data: { title: 'Home' }
  },
  {
    path:'',
    redirectTo: '/home',
    pathMatch: 'full'

  }
];

@NgModule({
  declarations: [
    AppComponent,
    ChannelComponent,
    AnswerComponent,
    QuestionComponent,
    HomeComponent,
    ChannelQuestionsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
      )// <--  <a routerLink="/channel" routerLinkActive="active-link">Channels</a>debugging purposes only
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
