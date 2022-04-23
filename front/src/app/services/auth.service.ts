import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { of, Observable } from 'rxjs';
import { catchError, mapTo, tap } from 'rxjs/operators';
import { Tokens } from '../models/tokens';

const config = {
  apiUrl: 'http://localhost:8082/helpdesk_vf'
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private readonly REFRESH_TOKEN = 'REFRESH_TOKEN';
  private  LOGGED_USER='LOGGED_USER';
  private  UserInfo='UserInfo';
  
   httpOptions = {
    headers: new HttpHeaders({
      responseType: 'blob'
    })
  };

  constructor(private http: HttpClient,private router:Router,private toastr: ToastrService) {}
  apiurl="5"

  login(username: string, password: string ): Observable<boolean> {
    
    return this.http.post<any>("http://localhost:8082/helpdesk_vf/authenticate",{emailId:username,password:password})
      .pipe(
        tap(token =>{ this.doLoginUser(username, token.token)
        console.log(token);
        }),
        mapTo(true),
        catchError(error => {
          alert(error.error);
          return of(false);
        }));
  }

  logout() {
    return this.http.post<any>(`${config.apiUrl}/logout`, {
      'refreshToken': this.getRefreshToken()
    }).pipe(
      tap(() => this.doLogoutUser()),
      mapTo(true),
      catchError(error => {
        alert(error.error);
        return of(false);
      }));
  }

  isLoggedIn() {
    return !!this.getJwtToken();
  }

  refreshToken() {
    return this.http.post<any>(`${config.apiUrl}/refresh`, {
      'refreshToken': this.getRefreshToken()
    }).pipe(tap((tokens: Tokens) => {
      this.storeJwtToken(tokens.jwt);
    }));
  }

  getJwtToken() {
    return localStorage.getItem(this.JWT_TOKEN);
  }

  private doLoginUser(username, token) {
    this.storeTokens(token,username);
  }
  public getLoggedUser() {
    return localStorage.getItem(this.LOGGED_USER);
  }

  public doLogoutUser() {
   
    this.removeTokens();
    
  }

  private getRefreshToken() {
    return localStorage.getItem(this.REFRESH_TOKEN);
  }

  private storeJwtToken(jwt: string) {
    localStorage.setItem(this.JWT_TOKEN, jwt);
  }

  private storeTokens(token,username) {
    localStorage.setItem(this.JWT_TOKEN, token);
    localStorage.setItem(this.REFRESH_TOKEN, token.refreshToken);
    localStorage.setItem(this.LOGGED_USER,username);
   
    this.getUserInfo();
    
    
  }

  private  removeTokens()  {
    localStorage.removeItem(this.JWT_TOKEN);
    localStorage.removeItem(this.REFRESH_TOKEN);
    localStorage.removeItem(this.LOGGED_USER);
    localStorage.removeItem(this.UserInfo);
    this.router.navigate(['login']); 
    
  
  };

  getUserInfo(): Observable<any>{
    console.log('my aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaid');
      return this.http.get(this.apiurl+'/userinfo/'+this.getLoggedUser()) 
       .pipe(
        tap(user =>{ 
        console.log('my id',user);
        localStorage.setItem(this.UserInfo,user.id);
        }),
        );
  }
  updateUser(user): Observable<any>{
    
    return this.http.put(this.apiurl+'/update',user) 
     .pipe(
      tap(Commande =>{ 
        console.log(Commande);
        this.toastr.success('Profile modifier ', 'Toastr fun!');
        }),
       mapTo(true)
        ,
        catchError(error => {
          
          this.toastr.error('Error !!!'+error, 'Toastr fun!');
          return of(false);
        }));
}
getallUsers(): Observable<any>{
    
  return this.http.get(this.apiurl+'/') 
   .pipe(
    tap(user =>{ 
    console.log(user);
    }),
    );
}
public getImages(id):Observable<any>{
  return this.http.get<any>("http://localhost:8081/daddesh/user/userImage/"+id,this.httpOptions)
  
}


}