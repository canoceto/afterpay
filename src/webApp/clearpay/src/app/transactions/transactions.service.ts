import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Transactions} from '../model/transactions';

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {

  constructor(private httpClient: HttpClient) {
  }

  getTransactionsList(walletId: string, getAllTransactions: boolean) {
    let urlAPiCall: string = environment.host;
    const option = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
    if (getAllTransactions) {
      urlAPiCall += 'transaction/all';
    } else {
      urlAPiCall += 'wallet/' + walletId + '/transactions';
    }
    return this
      .httpClient
      .get<Transactions[]>(urlAPiCall, option);
  }
}
