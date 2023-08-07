import { hostNameUrl } from "../config/api";
import axios from "axios";

export const login = (user) => {
  const data = axios.post(`${hostNameUrl}/auth/login`, user);
  return data;
};