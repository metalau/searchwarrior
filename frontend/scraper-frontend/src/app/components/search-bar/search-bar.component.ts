import { Component, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent {
  searchTerm: String = ''

  @Output() search = new EventEmitter<string>();

  onSearch() {
    if (this.searchTerm.trim()) {
      this.search.emit(this.searchTerm.trim());
    }
  }


}
