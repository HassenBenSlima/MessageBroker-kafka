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

  pageClients: any;
  clientsArray: any [] = [];
  clientSender: Client = new Client();
  idClient: number;

  constructor(public clientService: ClientsService, public http: Http) {
  }

  ngOnInit() {
    this.doSearch();
  }


  handle(id: number) {
    alert('selected option\'s value is ' + id);
    this.idClient = id;
    this.clientService.idClient = id;
    this.sendTo();


  }


  sendTo() {
    this.clientService.getClientById(this.idClient)
      .subscribe(data => {
        this.clientSender = data;
      }, err => {
        console.log(err);
      });

  }


  doSearch() {
    console.log('Hassen Ben Slima');
    this.clientService.getClients().subscribe(data => {
      this.pageClients = data;
      this.clientsArray = data;
      console.log(data);
    }, err => {
      console.log(err);
    });
  }
}
