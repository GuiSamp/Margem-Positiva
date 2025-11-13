import { Routes } from '@angular/router';
import { LoginPage } from './pages/login-page/login-page'; 
import { CadastroPage } from './pages/cadastro-page/cadastro-page';
import { PainelPage } from './pages/painel-page/painel-page';
import { NovoProdutoPage } from './pages/novo-produto-page/novo-produto-page';
import { MeusCadastrosPage } from './pages/meus-cadastros-page/meus-cadastros-page';

export const routes: Routes = [
  {
    path: '', 
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginPage, 
  },
  {
    path: 'cadastro',
    component: CadastroPage,
  },
  {
    path: 'painel',
    component: PainelPage,
  },
  {
    path: 'novo-produto',
    component: NovoProdutoPage,
  },
  { 
    path: 'meus-cadastros',
    component: MeusCadastrosPage,
  },
];
