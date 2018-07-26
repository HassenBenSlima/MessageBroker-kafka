import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {Message} from '../model/model.message';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

@Injectable()
export class MessageService {

  private messageSource = new BehaviorSubject<Array<Message>>([]);
  currentMessage = this.messageSource.asObservable();

  constructor(public http: Http) {

  }

  changeMessage(message: Message []) {
    this.messageSource.next(message);
  }

  saveMesssage(message: Message) {
    return this.http.post('http://localhost:8080/kafka/producer', message)
      .map(resp => resp.json());

  }

  getAllOldMessages() {
    return this.http.get('http://localhost:8080/oldMessages')
      .map(resp => resp.json());
  }


  getAllPrivateMessages(sender: string, reciever: string) {
    return this.http.get('http://localhost:8080/privateMessages?sender=' + sender + '&reciever=' + reciever)
      .map(resp => resp.json());
  }

  getAllPublicMessages() {
    return this.http.get('http://localhost:8080/publicMessages')
      .map(resp => resp.json());
  }

}



