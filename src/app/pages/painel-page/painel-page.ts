import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BotaoPrimario } from '../../components/buttons/botao-primario/botao-primario';
import { PlanoDeFundo } from '../../components/plano-de-fundo/plano-de-fundo'; 
import { BarraNavegacao } from '../../components/barra-navegacao/barra-navegacao';
import { ProdutoCard } from '../../components/produto-card/produto-card';


@Component({
  selector: 'app-painel-page',
  standalone: true,
  imports: [
    CommonModule,
    BotaoPrimario,
    PlanoDeFundo, 
    BarraNavegacao,
    ProdutoCard
  ],
  templateUrl: './painel-page.html',
  styleUrls: ['./painel-page.css']
})
export class PainelPage {
  produtosRecentes = [
    {
      imagemUrl: './produto.png',
      titulo: 'Empada de frango',
      custo: 38.50,
      quantidade: '25 UN/fornada',
      lucro: 53.50
    },
    {
      imagemUrl: './produto.png',
      titulo: 'Empada de carne',  
      custo: 42.00,
      quantidade: '25 UN/fornada',
      lucro: 58.00
    },
    {
      imagemUrl: './produto.png',
      titulo: 'Bolo de Pote',
      custo: 5.50,
      quantidade: '1 UN',
      lucro: 9.50
    }
   
  ];
}