import { Component } from '@angular/core';
import { InputBase } from '../../components/input-base/input-base';
import { BotaoGoogle } from '../../components/buttons/botao-google/botao-google';
import { BotaoPrimario } from '../../components/buttons/botao-primario/botao-primario';
import { PlanoDeFundo } from '../../components/plano-de-fundo/plano-de-fundo';
import { FormGroup, FormControl, Validators, ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { CommonModule } from '@angular/common';




@Component({
  selector: 'app-login-page',
  standalone: true, // <-- ESSA LINHA É CRÍTICA!
  imports: [InputBase, BotaoGoogle, BotaoPrimario, PlanoDeFundo, ReactiveFormsModule, CommonModule],
  templateUrl: './login-page.html',
})
export class LoginPage {

    loginForm!: FormGroup;
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      console.log('Formulário inválido!');
      return;
    }
    console.log('Formulário enviado:', this.loginForm.value);
  }

  getControl(name: string): FormControl{
    return this.loginForm.get(name) as FormControl;
  }
}
