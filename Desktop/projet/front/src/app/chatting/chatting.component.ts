import {Component, OnInit} from '@angular/core';
import {Message} from '../model/model.message';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-chatting',
  templateUrl: './chatting.component.html',
  styleUrls: ['./chatting.component.scss']
})
export class ChattingComponent implements OnInit {


  title = 'SparkChat';
  greetings: Message[] = [];
  disabled: boolean;
  name: string;
  message: string;

  private stompClient = null;

  constructor() {
  }

  ngOnInit() {
  }

  setConnected(connected: boolean) {
    this.disabled = connected;

    if (connected) {
      this.greetings = [];
    }
  }

  connect() {
    const socket = new SockJS('http://localhost:8080/chatting');
    this.stompClient = Stomp.over(socket);

    const _this = this;
    this.stompClient.connect({}, function (frame) {
      _this.setConnected(true);
      console.log('Connected: ' + frame);

      _this.stompClient.subscribe('/topic/chatting', function (chattingMessage) {
        _this.showGreeting(JSON.parse(chattingMessage.body));
      }, err => {
        console.log(err);
      });
    });
  }

  disconnect() {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }

    this.setConnected(false);
    console.log('Disconnected!');
  }

  /*
  * send Message object
  * */

  sendMessage() {
    this.stompClient.send(
      '/app/message',
      {},
      JSON.stringify({
        'content': this.message,
        'user': this.name
      })
    );
  }

  showGreeting(chattingMessage: Message) {
    this.greetings.push(chattingMessage);
  }


}
