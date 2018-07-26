import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import {Client} from '../model/model.client';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';


@Injectable()
export class ClientsService {

  idClient: number;
  nameClient: string;
  show = false;
  private ClientName = new BehaviorSubject('');
  currentName = this.ClientName.asObservable();

  constructor(public http: Http) {

  }

  changeNameClient(nameClient: string) {
    this.ClientName.next(nameClient);
  }

  getClients() {
    return this.http.get('http://localhost:8080/clients')
      .map(resp => resp.json());
  }

  getClientById(idClient: number) {
    return this.http.get('http://localhost:8080/clients/' + idClient)
      .map(resp => resp.json());
  }

  getClientByName(nameClient: string, password: string) {
    return this.http.get('http://localhost:8080/client?name=' + nameClient + '&pwd=' + password)
      .map(resp => resp.json());
  }

  saveClient(client: Client) {
    return this.http.post('http://localhost:8080/saveClient', client)
      .map(resp => resp.json());
  }

  updateClient(client: Client) {
    return this.http.put('http://localhost:8080/clients/' + client.idClient, client)
      .map(resp => resp.json());
  }

  deleteClient(id: number) {
    return this.http.delete('http://localhost:8080/clients/' + id)
      .map(resp => resp.json());
  }

}



