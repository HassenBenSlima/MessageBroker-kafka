import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatListUserComponent } from './chat-list-user.component';

describe('ChatListUserComponent', () => {
  let component: ChatListUserComponent;
  let fixture: ComponentFixture<ChatListUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChatListUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
