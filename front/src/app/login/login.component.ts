import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ClientsService} from '../services/clients.service';
import {Client} from '../model/model.client';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formdata: FormGroup;
  client: Client = new Client();

  constructor(public clientsService: ClientsService, public  router: Router) {
  }

  ngOnInit() {
    this.formdata = new FormGroup({
      name: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('[^ @]*@[^ @]*')
      ])),
      password: new FormControl('', [Validators.required, Validators.maxLength(15)])
    });
  }

  checkClientExistOrNot(data) {
    this.clientsService.getClientByName(data.name, data.password)
      .subscribe(clients => {
          this.client = clients;
          if (this.client != null) {
            this.router.navigate(['/chatting']);
            this.clientsService.nameClient = this.client.name;
          }

        }, err => {
          console.log(err);
        }
      );
  }


}
