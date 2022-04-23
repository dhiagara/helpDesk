import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ListReclamationComponent } from './emloyer-int/list-reclamation/list-reclamation.component';
import { ReclamationComponent } from './emloyer-int/reclamation/reclamation.component';
import { AuthGuard } from './guards/auth.guard';
import { RandomGuard } from './guards/random.guard';
import { SignInComponent } from './sign-in/sign-in.component';
import { TablesComponent } from './tables/tables.component';
import { TypographyComponent } from './typography/typography.component';

import { UserComponent } from './user/user.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path: 'home', component: DashboardComponent, canActivate: [RandomGuard]
  },
  {
    path: 'user', component: UserComponent,
  },
  {
    path: 'reclamation', component: ReclamationComponent, canActivate: [AuthGuard]
  },
  {
    path: 'tablesusers', component: TablesComponent, canActivate: [RandomGuard],
  },
  {
    path: 'listreclamation', component: TypographyComponent, canActivate: [RandomGuard]
  },
  {
    path: 'reclamationList', component: ListReclamationComponent, canActivate: [AuthGuard]
  },
  { path: 'login', component: SignInComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
