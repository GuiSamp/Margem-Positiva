import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlanoDeFundo } from '../../components/plano-de-fundo/plano-de-fundo';
import { HeaderPagina } from '../../components/header-pagina/header-pagina';
import { CadastroItemCard } from '../../components/cadastro-item-card/cadastro-item-card'; 

@Component({
  selector: 'app-meus-cadastros-page',
  standalone: true,
  imports: [
    CommonModule,
    PlanoDeFundo,
    HeaderPagina,
    CadastroItemCard 
  ],
  templateUrl: './meus-cadastros-page.html',
  styleUrls: ['./meus-cadastros-page.css']
})
export class MeusCadastrosPage implements OnInit {

  produtos = [
    {
      imagemUrl: '/produto.png', 
      categoria: 'Salgados',
      nome: 'Empada de frango',
      lucro: '62,50',
      custo: '30,50'
    },
    {
      imagemUrl: '/produto.png',
      categoria: 'Salgados',
      nome: 'Empada de frango',
      lucro: '62,50',
      custo: '30,50'
    },
  ];

  constructor() {}

  ngOnInit(): void { }

  onEditar(produto: any): void {
    console.log('Editar:', produto.nome);
  }

  onExcluir(produto: any): void {
    console.log('Excluir:', produto.nome);
  }
}