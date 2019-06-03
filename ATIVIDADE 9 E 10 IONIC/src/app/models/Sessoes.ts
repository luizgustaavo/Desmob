import { User } from "./Usuario";

export interface Session {
  id: string;
  initiatedAt: number;
  user: User;
  subject: string;
}
