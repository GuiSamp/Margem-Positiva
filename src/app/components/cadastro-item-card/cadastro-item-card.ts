import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastro-item-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cadastro-item-card.html',
  styleUrls: ['./cadastro-item-card.css']
})
export class CadastroItemCard {

  @Input() imagemUrl: string = '';
  @Input() categoria: string = '';
  @Input() nome: string = '';
  @Input() lucro: string = '';
  @Input() custo: string = '';

  @Output() onEditar = new EventEmitter<void>();
  @Output() onExcluir = new EventEmitter<void>();

  constructor() {}

  editar(): void {
    this.onEditar.emit();
  }

  excluir(): void {
    this.onExcluir.emit();
  }
}