import { Component, OnInit, ChangeDetectorRef  } from '@angular/core';
import { UserCreationEvent } from '../models/user-creation-event';
import { UserService } from '../services/user-creation-service';


@Component({
  selector: 'app-user-creation-viewer',
  templateUrl: './user-creation-viewer.component.html',
  styleUrls: ['./user-creation-viewer.component.css']
})
export class UserCreationViewerComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'date'];
  userCreationEvents: UserCreationEvent[] = [];
  userCreationEventsHelper: UserCreationEvent[] = [];

  constructor(private userService: UserService, private changeDetectorRefs: ChangeDetectorRef) {}

  ngOnInit() {
    this.userService.getNewUsersEventSource().addEventListener('message', message => {
        const object = JSON.parse((<any> message).data);
        const test: UserCreationEvent = object;
        this.userCreationEvents.push(new UserCreationEvent(test.id, test.login,  new Date()));
        this.changeDetectorRefs.detectChanges();
        console.log(this.userCreationEvents);
    });
  }
}
