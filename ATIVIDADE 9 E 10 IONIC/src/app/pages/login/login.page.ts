import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { Subject } from "src/app/models/Subjects";
import { Session } from "src/app/models/Sessoes";

@Component({
  selector: "app-login",
  templateUrl: "./login.page.html",
  styleUrls: ["./login.page.scss"]
})
export class LoginPage{
  username: String;
  subject: String;

  subjects: Subject[];
  session: Session = {
    id: Math.random().toString(),
    initiatedAt: new Date().getTime(),
    subject: null,
    user: {
      id: Math.random(),
      name: ""
    }
  };

  constructor(
    private _router: Router
  ) {}

  
  login() {}

  goChat() {
    this._router.navigate(["chat"]);
  }

  get options() {
    return this.subjects;
  }
}
