import { Component, OnInit } from '@angular/core';
import { Stock } from '../models/Stock';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-edit-stock',
  templateUrl: './edit-stock.component.html',
  styleUrls: ['./edit-stock.component.css']
})
export class EditStockComponent implements OnInit {

  code: string = '';
  showEditForm: boolean = false;
  stockToEdit: Stock;
  showNotFoundMessage: boolean = false;  
  success: boolean = false;
  fail: boolean = false;

  constructor(
    private stockService: StockService
  ) { }

  ngOnInit() {
  }

  findStock() {
    this.stockService.findByCode(this.code).subscribe(response => {
      this.stockToEdit = response as Stock;
      this.showNotFoundMessage = false;
      this.showEditForm = true;
      this.code = '';
    }, error => {
      this.showNotFoundMessage = true;
      this.success = false;
      this.fail = false;
    });
  }

  updateStock() {
    this.stockService.updateStock(this.stockToEdit).subscribe(response => {
      this.showEditForm = false;
      this.success = true;
      this.fail = false;
    }, error => {
      this.success = false;
      this.fail = true;
    })
  }

}
