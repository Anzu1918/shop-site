import { Component, OnInit } from '@angular/core';
import { Item } from '../models/Item';
import { Stock } from '../models/Stock';
import { ItemsService } from '../services/items.service';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  itemId: number;
  itemToUpdate: Item;  
  stockId: number;
  stockCode: string;
  stocks: Stock[] = [];
  existStocks: boolean = true;
  respondeSuccess: boolean = false;
  respondeFail: boolean = false;
  showEditForm: boolean = false;
  showNotFoundMessage: boolean = false;
  success: boolean = false;
  fail: boolean = false;

  constructor(
    private stockService: StockService,
    private itemService: ItemsService
  ) { }

  ngOnInit() {
    this.stockService.getStock().subscribe(response => {
      this.stocks = response as Stock[];
      this.existStocks = true;
    }, error => {
      this.existStocks = false;
    });
  }

  findItemById() {
    this.itemService.getItemById(this.itemId).subscribe(response => {
      this.itemToUpdate = response as Item;
      this.showNotFoundMessage = false;
      this.showEditForm = true;
    }, error => {
      this.showNotFoundMessage = true;
      this.showEditForm = false;
      this.success = false;
      this.fail = false;
    });
  }

  updateItem() {
    this.itemService.updateItem(this.itemToUpdate).subscribe(response => {
      this.success = true;
      this.fail = false;
      this.showEditForm = false;
      this.itemId = null;
    }, error => {
      this.success = false;
      this.fail = true;
    });
  }

}
