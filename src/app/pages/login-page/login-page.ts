import { Component } from '@angular/core';
import { InputBase } from '../../components/input-base/input-base';
import { BotaoGoogle } from '../../components/buttons/botao-google/botao-google';
import { BotaoPrimario } from '../../components/buttons/botao-primario/botao-primario';

@Component({
  selector: 'app-login-page',
  standalone: true, // <-- ESSA LINHA É CRÍTICA!
  imports: [InputBase, BotaoGoogle, BotaoPrimario],
  templateUrl: './login-page.html',
})
export class LoginPage {}
