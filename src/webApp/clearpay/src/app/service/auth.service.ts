import {Injectable} from '@angular/core';
import {auth, User} from 'firebase/app';
import {AngularFireAuth} from '@angular/fire/auth';
import {AngularFirestore} from '@angular/fire/firestore';
import {Router} from '@angular/router';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: User | undefined;
  useEventChange: Subject<User> = new Subject<User>();

  constructor(public fireAuth: AngularFireAuth, private firebase: AngularFirestore, private router: Router) {
    this.fireAuth.user.subscribe((user) => {
      if (user) {
        this.user = user;
        this.useEventChange.next(this.user);
        localStorage.setItem('user', JSON.stringify(this.user));
      } else {
        // this.user = null;
        // this.useEventChange.next(null);
        localStorage.removeItem('user');
      }
    });
  }

  login(email: string, password: string): Promise<any> {
    return this.fireAuth.signInWithEmailAndPassword(
      email,
      password
    );
  }

  async register(email: string, password: string) {
    await this.fireAuth.createUserWithEmailAndPassword(email, password).then((credentials) => {
        this.firebase.collection('credit').add({
          credit: 100,
          userId: credentials.user.uid
        });
        // Defaut values, because   PRODUCTO
        // const productTemp: {
        //   id: "",
        //   name: "email",
        //   price: 20,
        //   ventaActiva: false,
        //   owner: crentials.user.uid
        // };
      }
    );
  }

  loginWithGoogle(): Promise<any> {
    return this.fireAuth.signInWithPopup(new auth.GoogleAuthProvider());
  }

  isLoggedIn(): boolean {
    const user = JSON.parse(<string>localStorage.getItem('user'));
    debugger
    return user !== null;
  }

  async logout() {
    await this.fireAuth.signOut();
    localStorage.clear();
    // this.useEventChange.next(null);
    await this.router.navigate(['home']);
  }
}
