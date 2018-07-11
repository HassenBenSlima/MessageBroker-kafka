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
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ChatViewComponent,
    ChatNavBarComponent,
    ChatListMessageComponent,
    ChatListUserComponent,
    ChatFooterComponent,

  ],
  imports: [
    BrowserModule, HttpModule, FormsModule, ReactiveFormsModule

  ],
  providers: [ClientsService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
