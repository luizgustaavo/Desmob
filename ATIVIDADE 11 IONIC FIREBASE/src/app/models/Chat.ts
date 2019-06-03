import { User } from "./Usuario";
import { Message } from "./Mensagens";

export interface Chat {
  subject: String;
  username: String;
  messages?: Message[];
}
