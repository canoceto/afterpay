import {Injectable} from '@angular/core';
import {Wallet} from '../model/wallet';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  constructor(private httpClient: HttpClient) {
  }

  deleteProduct(id: string) {
    return null;
  }

  getWalletList(userId: string, getAllWallet: boolean): Observable<Wallet[]> {
    let urlAPiCall: string = environment.host;
    const option = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
    if (getAllWallet) {
      urlAPiCall += 'wallet/all';
    } else {
      urlAPiCall += 'user/' + userId + '/wallets';
    }
    return this
      .httpClient
      .get<Wallet[]>(urlAPiCall, option);
  }

  updateProduct(data: Wallet) {
    return null;
  }
}
