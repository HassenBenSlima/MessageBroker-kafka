import {Component, OnInit} from '@angular/core';
import {ClientsService} from '../services/clients.service';
import {Http} from '@angular/http';
import {Client} from '../model/model.client';

@Component({
  selector: 'app-chat-list-user',
  templateUrl: './chat-list-user.component.html',
  styleUrls: ['./chat-list-user.component.scss']
})
export class ChatListUserComponent implements OnInit {

  sendToo: string;
  pageClients: any;
  clientsArray: any [] = [];
  clientSender: Client = new Client();
  idClient: number;

  constructor(public clientService: ClientsService, public http: Http) {
  }

  ngOnInit() {
    this.doSearch();
    this.clientService.currentName.subscribe(sendToo => this.sendToo = sendToo);

  }

  newMessage(nameClient: string) {
    this.clientService.changeNameClient(nameClient);
  }

  changeNameClient(nameClient: string) {
    this.newMessage(nameClient);
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
