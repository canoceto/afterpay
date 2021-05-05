import {Injectable} from '@angular/core';
import {AngularFireAuth} from '@angular/fire/auth';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {switchMap, take} from 'rxjs/operators';

@Injectable()
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private auth: AngularFireAuth) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return this.auth.idToken.pipe(take(1),
      switchMap((tokenId: string) => {
        let headers = req.headers.set('Content-Type', 'application/json');
        if (tokenId) {
          headers = headers.append('Authorization', `Bearer ${tokenId}`);
        }
        return next.handle(req.clone({headers}));
      })
    );
  }
}
