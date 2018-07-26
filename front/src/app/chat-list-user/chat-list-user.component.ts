import {Component, OnInit} from '@angular/core';
import {ClientsService} from '../services/clients.service';
import {Http} from '@angular/http';
import {MessageService} from '../services/message.service';
import {Message} from '../model/model.message';

@Component({
  selector: 'app-chat-list-user',
  templateUrl: './chat-list-user.component.html',
  styleUrls: ['./chat-list-user.component.scss']
})
export class ChatListUserComponent implements OnInit {
  sendToo: string;
  pageClients: any;
  clientsArray: any [] = [];

  oldMessages: Message[] = [];

  constructor(public clientService: ClientsService, public http: Http, public messageService: MessageService) {
  }


  ngOnInit() {
    this.doSearch();
    this.clientService.currentName.subscribe(sendToo => this.sendToo = sendToo);
    this.messageService.currentMessage.subscribe(oldMessages => this.oldMessages = oldMessages);

  }

  newListMessages(publicMessages: Message []) {
    this.messageService.changeMessage(publicMessages);
  }

  newMessage(nameClient: string) {
    this.clientService.changeNameClient(nameClient);
  }

  changeNameClient(nameClient: string) {
    this.newMessage(nameClient);
    if (nameClient === 'everyone') {
      this.clientService.show = false;

      // alert(nameClient);
      this.messageService.getAllPublicMessages().subscribe(
        data => {
          this.oldMessages = data;
          console.log(data);

        }, err => {
          console.log(err);
        }
      );
    } else {
      // alert('sender: ' + this.clientService.nameClient + ' / reciver :' + nameClient);
      this.clientService.show = true;
      this.messageService.getAllPrivateMessages(this.clientService.nameClient, nameClient).subscribe(
        data => {
          this.oldMessages = data;
          console.log(data);
        }, err => {
          console.log(err);
        }
      );
    }

    this.newListMessages(this.oldMessages);
  }

  doSearch() {
    this.clientService.getClients().subscribe(data => {
      this.pageClients = data;
      this.clientsArray = data;
    }, err => {
      console.log(err);
    });
  }
}
