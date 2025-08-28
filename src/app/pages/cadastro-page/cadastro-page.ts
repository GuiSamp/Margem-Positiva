import { Component } from '@angular/core';
import { PlanoDeFundo } from "../../components/plano-de-fundo/plano-de-fundo";
import { InputBase } from "../../components/input-base/input-base";
import { BotaoPrimario } from "../../components/buttons/botao-primario/botao-primario";
import { BotaoGoogle } from "../../components/buttons/botao-google/botao-google";


@Component({
  selector: 'app-cadastro-page',
  standalone: true,
  imports: [PlanoDeFundo, InputBase, BotaoPrimario, BotaoGoogle],
  templateUrl: './cadastro-page.html',
  styleUrl: './cadastro-page.css'
})
export class CadastroPage {

}
