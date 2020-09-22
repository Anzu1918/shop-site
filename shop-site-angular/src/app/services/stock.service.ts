import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Stock } from '../models/Stock';
import { env } from 'process';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  path = '/api/v1/stock';

  constructor(
    private http: HttpClient
  ) { }

  getStock() {
    return this.http.get(this.path);
  }

  saveStock(stock: Stock) {
    return this.http.post(this.path, stock);
  }

  findByCode(code: string) {
    return this.http.get(`${this.path}/${code}`)
  }

  updateStock(stock: Stock) {
    return this.http.put(`${this.path}/${stock.id}`, stock);
  }
}
