import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from '../models/Item';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  path = '/api/v1/item';

  constructor(
    private http: HttpClient
  ) { }

  getItems() {
    return this.http.get(this.path);
  }

  saveItem(item: Item) {
    return this.http.post(this.path, item);
  }

  getItemById(id: number) {
    return this.http.get(`${this.path}/${id}`);
  }

  updateItem(item: Item) {
    return this.http.put(`${this.path}/${item.id}`, item);
  }
}
