import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Client} from '../model/model.client';
import {ClientsService} from '../services/clients.service';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.scss']
})
export class NewClientComponent implements OnInit {

  form: FormGroup;
  client: Client = new Client();
  mode = 1;

  constructor(public clientsService: ClientsService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(3)]]

    });
  }

  saveClient() {
    console.log(this.form.value);

    this.client = this.form.value;

    this.clientsService.saveClient(this.client)
      .subscribe(data => {
          this.client = data;
          this.mode = 2;
        }, err => {
          console.log(err);
        }
      );
  }
}
