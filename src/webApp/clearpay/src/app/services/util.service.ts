import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Transactions} from '../model/transactions';

@Injectable({
  providedIn: 'root'
})
export class UtilService {


  constructor(private httpClient: HttpClient) {
  }

  makeTransfer(walletId: string, amount: number, toWallet: string) {
    const option = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
    };
    const body = {
      id: walletId,
      quantity: amount,
      to: toWallet
    };
    return this.httpClient.post<Transactions>(environment.host + 'transaction/new', JSON.stringify(body), option);
  }
}
