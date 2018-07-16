import {Component, OnInit} from '@angular/core';
import {Message} from '../model/model.message';
import {ClientsService} from '../services/clients.service';
import {WebsocketService} from '../services/websocket.service';
import {NotificationService} from '../services/notification.service';
import {Client} from '../model/model.client';

@Component({
  selector: 'app-chatting',
  templateUrl: './chatting.component.html',
  styleUrls: ['./chatting.component.scss']
})
export class ChattingComponent implements OnInit {

  notification = 0;
  greetings: Message[] = [];
  participants: Client[] = [];
  disabled: boolean;
  message: string;
  sendTo: string;
  stompClient;
  name = '';

  constructor(public clientsService: ClientsService,
              private webSocketService: WebsocketService,
              public data: NotificationService) {

    this.stompClient = this.webSocketService.connectSocket();
    this.name = this.clientsService.nameClient;
    console.log('name :' + this.name);


  }

  ngOnInit() {

    this.connect();
    this.data.currentNotification.subscribe(notification => this.notification = notification);
    this.clientsService.currentName.subscribe(sendTo => this.sendTo = sendTo);


  }

  setConnected(connected: boolean) {
    this.disabled = connected;

    if (connected) {
      this.greetings = [];
    }
  }

  connect() {
    const _this = this;
    this.stompClient.connect({}, function (frame) {
      _this.setConnected(true);
      console.log('Connected: ' + frame);


      _this.stompClient.subscribe('/topic/chatting', function (chattingMessage) {
        _this.showALLMessages(JSON.parse(chattingMessage.body));

      }, err => {
        console.log(err);
      });

      _this.stompClient.subscribe('/topic/notification', function (notifications) {
        _this.newNotification(JSON.parse(notifications.body).count);
      }, err => {
        console.log(err);
      });

      _this.stompClient.subscribe('/topic/chatting-' + _this.name, function (message) {
        console.log('private message' + JSON.parse(message.body));
        _this.showALLMessages(JSON.parse(message.body));
      }, err => {
        console.log(err);
      });

      _this.stompClient.subscribe('/user/exchange/amq.direct/chat.message', function (message) {
        _this.showALLMessages(JSON.parse(message.body));
      });

    });

  }

  /*
  * send Message object
  * */

  disconnect() {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }

    this.setConnected(false);
    console.log('Disconnected!');
  }

  sendMessage() {
    this.stompClient.send(
      '/app/message',
      {},
      JSON.stringify({
        'content': this.message,
        'user': this.name
      })
    );
    this.message = '';
  }

  sendPrivateMessage() {
    console.log('content :' + this.message + 'user' + this.name);

    this.stompClient.send(
      '/app/chat.private.' + this.sendTo,
      {},
      JSON.stringify({
        'content': this.message,
        'user': this.name
      })
    );

    this.message = '';
  }

  showALLMessages(chattingMessage: Message) {
    this.greetings.push(chattingMessage);
  }

  showALLCurrentUsers(currentClient: Client) {
    this.participants.push(currentClient);
  }

  newNotification(newNotification: number) {
    this.data.changeNotification(newNotification);
  }

}
