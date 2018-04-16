//added missing lines
// Modules
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { SellingComponent } from './components/selling/selling.component';
import { PurchaseComponent } from './components/purchase/purchase.component';

export const routes: Routes = [
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'selling', component: SellingComponent},
  { path: 'purchase', component:PurchaseComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes, {useHash: true}) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}