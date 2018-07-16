import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ChatViewComponent} from './chat-view/chat-view.component';
import {ChatNavBarComponent} from './chat-nav-bar/chat-nav-bar.component';
import {ChatListMessageComponent} from './chat-list-message/chat-list-message.component';
import {ChatListUserComponent} from './chat-list-user/chat-list-user.component';
import {ChatFooterComponent} from './chat-footer/chat-footer.component';
import {ClientsService} from './services/clients.service';
import {MessageService} from './services/message.service';
import {HttpModule} from '@angular/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ChattingComponent} from './chatting/chatting.component';
import {LoginComponent} from './login/login.component';
import {NewClientComponent} from './new-client/new-client.component';
import {RouterModule, Routes} from '@angular/router';
import {MessageBrokerComponent} from './message-broker/message-broker.component';
import {WebsocketService} from './services/websocket.service';
import {NotificationService} from './services/notification.service';


const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'new-client', component: NewClientComponent},
  {path: 'chatting', component: MessageBrokerComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}

];

@NgModule({
  declarations: [
    AppComponent,
    ChatViewComponent,
    ChatNavBarComponent,
    ChatListMessageComponent,
    ChatListUserComponent,
    ChatFooterComponent,
    ChattingComponent,
    LoginComponent,
    NewClientComponent,
    MessageBrokerComponent,

  ],
  imports: [
    BrowserModule, HttpModule, RouterModule.forRoot(appRoutes), FormsModule, ReactiveFormsModule,

  ],
  providers: [ClientsService, MessageService, WebsocketService, NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
