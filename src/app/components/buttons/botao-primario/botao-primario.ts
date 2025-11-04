import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importe o CommonModule

@Component({
  selector: 'app-botao-primario',
  standalone: true, // Garanta que está como standalone
  imports: [CommonModule], // Adicione CommonModule para usar *ngIf
  templateUrl: './botao-primario.html',
  styleUrl: './botao-primario.css'
})
export class BotaoPrimario {

  @Input() name!: string;

  // Input para receber o caminho do arquivo da imagem (ex: '/assets/icons/meu-icone.png')
  @Input() iconUrl?: string; 

}