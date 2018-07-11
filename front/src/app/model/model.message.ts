import {Client} from './model.client';

export class Message {

  idMsg: any = null;

  sender: number;

  receiver: Client;

  content: string;
}
