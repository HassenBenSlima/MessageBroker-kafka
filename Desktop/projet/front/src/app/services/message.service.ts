import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {Message} from '../model/model.message';

@Injectable()
export class MessageService {
  constructor(public http: Http) {

  }

  saveMesssage(message: Message) {
    return this.http.post('http://localhost:8080/kafka/producer', message)
      .map(resp => resp.json());

  }

}



