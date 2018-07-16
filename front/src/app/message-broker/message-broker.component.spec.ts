import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageBrokerComponent } from './message-broker.component';

describe('MessageBrokerComponent', () => {
  let component: MessageBrokerComponent;
  let fixture: ComponentFixture<MessageBrokerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessageBrokerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageBrokerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
