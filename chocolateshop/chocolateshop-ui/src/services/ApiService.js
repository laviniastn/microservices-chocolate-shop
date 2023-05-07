import axios from "axios";

const BASE_URL = `http://localhost:8083`;

function login(user) {
  return axios.post(`${BASE_URL}/userservice/auth/login`, user);
}

function createUser(user) {
  return axios.post(`${BASE_URL}/userservice/users/create`, user);
}

function findUserByEmail(email) {
  return axios.get(`${BASE_URL}/userservice/users/email=` + email);
}

export { login, createUser, findUserByEmail };
