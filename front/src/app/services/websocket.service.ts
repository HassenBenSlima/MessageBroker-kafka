import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {Injectable} from '@angular/core';

@Injectable()
export class WebsocketService {
  constructor() {
  }

  connectSocket() {
    const socket = new SockJS('http://localhost:8080/chatting');
    const stompClient = Stomp.over(socket);

    ;

    /* const sessionId = /\/([^\/]+)\/websocket/.exec(socket._transport.url)[1];
     console.log('connected, session id: ' + sessionId);
 */
    return stompClient;
  }


}
