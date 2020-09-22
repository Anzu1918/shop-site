import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListStockComponent } from './list-stock/list-stock.component';
import { CreateStockComponent } from './create-stock/create-stock.component';
import { EditStockComponent } from './edit-stock/edit-stock.component';
import { CreateItemComponent } from './create-item/create-item.component';
import { ListItemComponent } from './list-item/list-item.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListStockComponent,
    CreateStockComponent,
    EditStockComponent,
    CreateItemComponent,
    ListItemComponent,
    EditItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
