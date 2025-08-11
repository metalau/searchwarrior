import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface ScrapedItem {
  title: string;
  imgUrl?: string;
  vidUrl?: string;
  tags: string[];
  siteName: string;

}

@Injectable({
  providedIn: 'root'
})
export class ScraperService {

  private apiUrl = '/api/scrape';

  constructor(private http: HttpClient) { }

  search(term: string): Observable<ScrapedItem[]> {
    return this.http.get<ScrapedItem[]>(`${this.apiUrl}?query=${encodeURIComponent(term)}`);
  }
}
