import {Component} from '@angular/core';
import {Http} from '@angular/http';
import {ChatListUserComponent} from './chat-list-user/chat-list-user.component';
import {ClientsService} from './services/clients.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';

}
