import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ChannelComponent } from './channel/channel.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { ChannelQuestionsComponent } from './channel-questions/channel-questions.component';
import { AnswersComponent } from './answers/answers.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import {
  MatButtonModule,
  MatMenuModule,
  MatIconModule
} from '@angular/material';

const appRoutes: Routes = [
  {
    path: 'channel',
    component: ChannelComponent,
    data: { title: 'Channel List' }
  },
  {
    path: 'channel-questions/:id',
    component: ChannelQuestionsComponent,
    data: {title: 'Channel Questions'}
  },
  {
    path: 'answers/:id',
    component: AnswersComponent,
    data: {title: 'Answers'}
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
    HomeComponent,
    ChannelQuestionsComponent,
    AnswersComponent,
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    FormsModule,
    MatToolbarModule,
    MatCardModule,
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
