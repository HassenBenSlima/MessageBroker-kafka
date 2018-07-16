import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';


@Injectable()
export class NotificationService {

  private notificationSource = new BehaviorSubject(0);
  currentNotification = this.notificationSource.asObservable();

  constructor() {
  }

  changeNotification(notificationNumber: number) {
    this.notificationSource.next(notificationNumber);
  }

}
