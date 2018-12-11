import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    getNewUsersEventSource(): EventSource {
      return new EventSource('http://localhost:8080/userCreationEvent');
  }
}