import { User } from "./Usuario";

export interface Message {
  sendAt: number;
  id: Number;
  user: User;
  text: String;
}
