import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of, Observable } from 'rxjs';
import { catchError, mapTo, tap } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AddUserService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient, private toastr: ToastrService) { }

  public registerUser(formData: FormData): Observable<any> {
    console.log(formData)
    return this.http.post<any>("http://localhost:8082/helpdesk_vf/user/regg", formData, this.httpOptions)
      .pipe(
        tap(blog => {
          console.log(blog);
          this.toastr.success('utilisateur Ajouter', 'Toastr fun!');
        }),
        mapTo(true)
        ,
        catchError(error => {

          this.toastr.error('error !!!' + error, 'Toastr fun!');
          return of(false);
        }));
  }
  addReclamation(username: string, password: string): Observable<boolean> {

    return this.http.post<any>("http://localhost:8082/helpdesk_vf/reclamation/add", { emailId: username, password: password })
      .pipe(
        tap(blog => {
          console.log(blog);
          this.toastr.success('Request Envoyer', 'Toastr fun!');
        }),
        mapTo(true)
        ,
        catchError(error => {

          this.toastr.error('error !!!' + error, 'Toastr fun!');
          return of(false);
        }));

  }
  findReclamationByUser(id): Observable<any> {

    const user = { id: 2 }
    return this.http
      .get<any>("http://localhost:8082/helpdesk_vf/reclamation/findByUser?user=" + localStorage.getItem('UserInfo'), this.httpOptions)

      .pipe(
        tap(blog => {
          console.log(blog);
          this.toastr.success('Reclamation Afficher', 'Toastr fun!');
        }),

        catchError(error => {

          this.toastr.error('Reclamation !!!' + error, 'Toastr fun!');
          return of(false);
        }));
  }
  getAllUsers(id): Observable<any> {

    const user = { id: 2 }
    return this.http
      .get<any>("http://localhost:8082/helpdesk_vf/user/", this.httpOptions)

      .pipe(
        tap(blog => {
          console.log(blog);
          this.toastr.success('Reclamation Afficher', 'Toastr fun!');
        }),

        catchError(error => {

          this.toastr.error('Reclamation !!!' + error, 'Toastr fun!');
          return of(false);
        }));
  }
  getAllReclamation(): Observable<any> {

    const user = { id: 2 }
    return this.http
      .get<any>("http://localhost:8082/helpdesk_vf/reclamation/", this.httpOptions)

      .pipe(
        tap(blog => {
          console.log(blog);
          this.toastr.success('Reclamation Afficher', 'Toastr fun!');
        }),

        catchError(error => {

          this.toastr.error('Reclamation !!!' + error, 'Toastr fun!');
          return of(false);
        }));
  }



  accepterReclamation(username: string, password: string): Observable<boolean> {

    return this.http.post<any>("http://localhost:8082/helpdesk_vf/reclamation/accept", { emailId: username, password: password })
      .pipe(
        tap(blog => {
          console.log(blog);
          this.toastr.success('Compte créér Envoyer', 'Toastr fun!');
        }),
        mapTo(true)
        ,
        catchError(error => {

          this.toastr.error('error !!!' + error, 'Toastr fun!');
          return of(false);
        }));

  }


}
