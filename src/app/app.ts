import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PlanoDeFundo } from './components/plano-de-fundo/plano-de-fundo';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('frontend');
}
