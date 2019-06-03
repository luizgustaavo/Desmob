import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { Chat } from "src/app/models/Chat";

@Component({
  selector: "app-home",
  templateUrl: "home.page.html",
  styleUrls: ["home.page.scss"]
})
export class HomePage {
  private _options: any[] = [
    {
      value: 1,
      label: "Cinema"
    },
    {
      value: 2,
      label: "Curiosidades"
    },
    {
      value: 3,
      label: "Esportes"
    }
  ];

  private mensagensList = [
    {
      id: '1',
      username: 'João',
      mensagens: 'olá',
    },
    {
      id: '2',
      username: 'Maria',
      mensagens: 'alguém online?'
    },
    {
      id: '3',
      username: 'Rita',
      mensagens: 'estou chegando!'
    }
  ];

  chat: Chat = {
    subject: null,
    username: ""
  };

  constructor(private _router: Router) {}

  entrarNoChat() {
    this._router.navigate(["chat"]);
  }

  get options() {
    return this._options;
  }
}
