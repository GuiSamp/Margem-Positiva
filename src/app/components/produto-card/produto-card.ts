import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-produto-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './produto-card.html',
  styleUrls: ['./produto-card.css']
})
export class ProdutoCard {
  @Input() imagemUrl: string = '';
  @Input() titulo: string = '';
  @Input() custo: number = 0;
  @Input() quantidade: string = '';
  @Input() lucro: number = 0;
}
