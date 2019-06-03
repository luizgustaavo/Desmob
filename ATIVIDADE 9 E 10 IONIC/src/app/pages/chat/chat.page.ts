import { Component, OnInit } from "@angular/core";
import { Chat } from "src/app/models/Chat";
import { Session } from "src/app/models/Sessoes";
import { ActivatedRoute, Router } from "@angular/router";
import { LoadingController, NavController } from "@ionic/angular";
import { Message } from "src/app/models/Mensagens";

@Component({
  selector: "app-chat",
  templateUrl: "./chat.page.html",
  styleUrls: ["./chat.page.scss"]
})
export class ChatPage{
  session: Session;

  newMessageText: String;
  title: String;
  messages: Message[];

  constructor(
  ) {
    this.title = this.session.subject;
  }

  check(item) {
    if (item.user.id === this.session.user.id) {
      return true;
    }

    return false;
  }

  sendMessage() {
    const newMessage: Message = {
      id: Math.random(),
      sendAt: new Date().getTime(),
      user: this.session.user,
      text: this.newMessageText
    };
    this.messages = [...this.messages, newMessage];
    this.newMessageText = "";
  }
}
