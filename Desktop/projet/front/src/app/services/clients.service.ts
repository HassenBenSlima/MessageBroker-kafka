import {Http} from '@angular/http';
import {Injectable} from '@angular/core';


@Injectable()
export class ClientsService {

  idClient: number;

  constructor(public http: Http) {

  }

  getClients() {
    return this.http.get('http://localhost:8080/clients')
      .map(resp => resp.json());
  }

  getClientById(idClient: number) {
    return this.http.get('http://localhost:8080/clients/' + idClient)
      .map(resp => resp.json());
  }

}



