import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';

import { PlanoDeFundo } from '../../components/plano-de-fundo/plano-de-fundo';
import { BotaoPrimario } from '../../components/buttons/botao-primario/botao-primario';
import { HeaderPagina } from '../../components/header-pagina/header-pagina'; // Novo
import { InputClaro } from '../../components/input-claro/input-claro'; // Novo
import { MaterialCard } from '../../components/material-card/material-card'; // Novo

@Component({
  selector: 'app-novo-produto-page',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    PlanoDeFundo,
    BotaoPrimario,
    HeaderPagina,
    InputClaro,
    MaterialCard
  ],
  templateUrl: './novo-produto-page.html',
  styleUrls: ['./novo-produto-page.css']
})
export class NovoProdutoPage implements OnInit {

  novoProdutoForm!: FormGroup;

  materiais = [
    { nome: 'Farinha de trigo', quantidade: '500g' },
    { nome: 'Ovo', quantidade: '3 unidades' },
    { nome: 'Manteiga', quantidade: '200g' },
    { nome: 'Frango Desfiado', quantidade: '600g' },
  ];

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.novoProdutoForm = this.fb.group({
      campo1: ['', Validators.required],
      campo2: [''],
      campo3: [''],
      campo4: [''],
      campo5: [''],
      campo6: [''],
      campo7: [''],
      campo8: [''],
    });
  }

  getControl(name: string): FormControl {
    return this.novoProdutoForm.get(name) as FormControl;
  }

  onSubmit(): void {
    if (this.novoProdutoForm.invalid) {
      console.log('Formulário inválido');
      this.novoProdutoForm.markAllAsTouched();
      return;
    }
    console.log('Formulário enviado:', this.novoProdutoForm.value);
  }
}