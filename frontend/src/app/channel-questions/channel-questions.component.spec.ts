import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChannelQuestionsComponent } from './channel-questions.component';

describe('ChannelQuestionsComponent', () => {
  let component: ChannelQuestionsComponent;
  let fixture: ComponentFixture<ChannelQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChannelQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChannelQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
