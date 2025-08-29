import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import { PlanoDeFundo } from "../../components/plano-de-fundo/plano-de-fundo";
import { InputBase } from "../../components/input-base/input-base";
import { BotaoPrimario } from "../../components/buttons/botao-primario/botao-primario";
import { BotaoGoogle } from "../../components/buttons/botao-google/botao-google";

@Component({
  selector: 'app-cadastro-page',
  standalone: true,
  imports: [
    PlanoDeFundo,
    InputBase,
    BotaoPrimario,
    BotaoGoogle,
    ReactiveFormsModule
  ],
  templateUrl: './cadastro-page.html',
  styleUrl: './cadastro-page.css'
})
export class CadastroPage implements OnInit {

  cadastroForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.cadastroForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      telefone: ['', [Validators.required]],
      cpf_cnpj: ['', [Validators.required]],
      senha: ['', [Validators.required, Validators.minLength(6)]],
      repita_senha: ['', [Validators.required]]
    }, {

      validators: this.validarSenha
    });
  }

  validarSenha(control: AbstractControl): ValidationErrors | null {
    const senha = control.get('senha');
    const repitaSenha = control.get('repita_senha');

    if (senha && repitaSenha && senha.value !== repitaSenha.value) {
      repitaSenha.setErrors({ mismatch: true });
      return { mismatch: true };
    } else {
      if (repitaSenha?.hasError('mismatch')) {
        repitaSenha.setErrors(null);
      }
      return null;
    }
  }

  getControl(name: string): FormControl {
    return this.cadastroForm.get(name) as FormControl;
  }

  onSubmit(): void {
    if (this.cadastroForm.invalid) {
      this.cadastroForm.markAllAsTouched();
      console.log('Formulário inválido!');
      return;
    }
    console.log('Formulário enviado:', this.cadastroForm.value);
  }
}
