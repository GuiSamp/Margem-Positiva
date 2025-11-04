import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';


export interface CardInfo {
  title: string;
  iconUrl: string;
  count: number;
  label: string;
}

@Component({
  selector: 'app-info-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './info-card.html',
  styleUrls: ['./info-card.css']
})
export class InfoCardComponent {
  // Input para receber o título principal da seção
  @Input() sectionTitle: string = "Meus Itens";

  // Input que recebe um ARRAY de informações para os cards
  @Input() items: CardInfo[] = []; 
}