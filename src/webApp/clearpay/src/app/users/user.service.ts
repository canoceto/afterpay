import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {UserClient} from '../model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  getUsers(): Observable<UserClient[]> {
    const option = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
    return this
      .httpClient
      .get<UserClient[]>(environment.host + 'user/all', option);
  }

  updateUser(userClient: UserClient) {
    return null;
  }

  deleteUser(id: string) {
    return null;
  }
}
