import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-barra-navegacao',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './barra-navegacao.html',
  styleUrls: ['./barra-navegacao.css']
})
export class BarraNavegacao {
  @Input() painelIconUrl: string = '';
  @Input() cadastrosIconUrl: string = '';
  @Input() perfilIconUrl: string = '';
}