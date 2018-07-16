import {Component, OnInit} from '@angular/core';
import {NotificationService} from '../services/notification.service';

@Component({
  selector: 'app-chat-nav-bar',
  templateUrl: './chat-nav-bar.component.html',
  styleUrls: ['./chat-nav-bar.component.scss']
})
export class ChatNavBarComponent implements OnInit {

  notification = 0;

  constructor(private data: NotificationService) {
  }

  ngOnInit() {
    this.data.currentNotification.subscribe(notification => this.notification = notification);
  }

}
