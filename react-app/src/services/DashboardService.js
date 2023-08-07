import { hostNameUrl } from "../config/api";
import axios from "axios";

export const getAllTrades = (token) => {
  let config = {
    headers: {Authorization: `Bearer ${token}`}
  }
  const data = axios.get(`${hostNameUrl}/trades`, config);
  return data;
};

export const getUserTrades = (token, username) => {
  let config = {
    headers: {Authorization: `Bearer ${token}`}
  }
  const data = axios.get(`${hostNameUrl}/trades/user/${username}`, config);
  return data;
};