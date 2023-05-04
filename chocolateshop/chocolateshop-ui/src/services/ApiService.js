import axios from "axios";

const BASE_URL = "http://localhost:8083";

function login(user) {
  return axios.post("http://localhost:8083/userservice/auth/login", user);
}

export { login };
