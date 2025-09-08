import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BotaoPrimario } from '../../components/buttons/botao-primario/botao-primario';
import { PlanoDeFundo } from '../../components/plano-de-fundo/plano-de-fundo'; // 1. IMPORTE AQUI

@Component({
  selector: 'app-painel-page',
  standalone: true,
  imports: [
    CommonModule,
    BotaoPrimario,
    PlanoDeFundo // 2. ADICIONE AQUI
  ],
  templateUrl: './painel-page.html',
  styleUrls: ['./painel-page.css']
})
export class PainelPage {

}