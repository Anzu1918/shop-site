import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateItemComponent } from './create-item/create-item.component';
import { CreateStockComponent } from './create-stock/create-stock.component';
import { EditItemComponent } from './edit-item/edit-item.component';
import { EditStockComponent } from './edit-stock/edit-stock.component';
import { ListItemComponent } from './list-item/list-item.component';
import { ListStockComponent } from './list-stock/list-stock.component';


const routes: Routes = [
  {
    path: 'stock/list',
    component: ListStockComponent
  },
  {
    path: 'stock/edit',
    component: EditStockComponent
  },
  {
    path: 'stock/create',
    component: CreateStockComponent
  },
  {
    path: 'item/list',
    component: ListItemComponent
  },
  {
    path: 'item/edit',
    component: EditItemComponent
  },
  {
    path: 'item/create',
    component: CreateItemComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
