import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule, NgIf, NgFor } from '@angular/common';
import { ScrapedItem, ScraperService } from './services/scraper.service';
import { SearchBarComponent } from "./components/search-bar/search-bar.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SearchBarComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  results: ScrapedItem[] = [];
  isLoading = false;

  constructor(private scraperService: ScraperService) {}

  onSearch(term: string) {
    this.isLoading = true;
    this.scraperService.search(term).subscribe({
      next:(data) => {
        this.results = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Search failed: ', err);
        this.isLoading = false;
      }
    });
  }
}
