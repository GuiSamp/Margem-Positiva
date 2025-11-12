import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-material-card',
  standalone: true,
  imports: [],
  templateUrl: './material-card.html',
})
export class MaterialCard {
  @Input() nome: string = '';
  @Input() quantidade: string = '';
}