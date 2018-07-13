import {Component, OnInit} from '@angular/core';
import {ClientsService} from '../services/clients.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MessageService} from '../services/message.service';

@Component({
  selector: 'app-chat-view',
  templateUrl: './chat-view.component.html',
  styleUrls: ['./chat-view.component.scss']
})
export class ChatViewComponent implements OnInit {


  message = '';
  formdata: FormGroup;


  constructor(public clientService: ClientsService, public messageService: MessageService) {

  }

  ngOnInit() {
    this.formdata = new FormGroup({
      message: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('[^ @]*@[^ @]*')
      ])),

    });
  }

  onClickSubmit(data) {
    this.message = data.message;

    alert('selected option\'s value is ' + this.clientService.idClient + ' message ' + this.message);


  }

}
