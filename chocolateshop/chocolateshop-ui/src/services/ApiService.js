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

function getAllUsers() {
  return axios.get(`${BASE_URL}/userservice/users`);
}

function deleteUserById(id) {
  return axios.delete(`${BASE_URL}/userservice/users/delete/` + id);
}

export { login, createUser, findUserByEmail, getAllUsers, deleteUserById };
