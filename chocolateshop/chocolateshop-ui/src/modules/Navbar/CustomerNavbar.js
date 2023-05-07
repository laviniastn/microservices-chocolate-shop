import React from "react";
import "./CustomerNavbar.css";
import logo from "../../../src/asserts/logo.png";
import cart from "../../../src/asserts/cart.png";
import { logout } from "../../services/AuthService";
import { useNavigate } from "react-router-dom";
import { isUserLoggedIn } from "../../services/AuthService";

import { useState } from "react";

function CustomerNavbar() {
  const [userLogged] = useState(isUserLoggedIn());
  const navigate = useNavigate();

  const handleLogout = () => {
    if (userLogged === true) logout();
    navigate("/login");
    window.location.reload();
  };

  return (
    <div className="navbar">
      <div className="logo">
        <a href="/">
          <img src={logo} alt="" width="30" height="30" />
        </a>
      </div>
      <ul className="navigation">
        <li>
          <a href="/">Home</a>
        </li>
        <li>
          <a href="/cart">
            <img src={cart} alt="" width="20" height="20" />
          </a>
        </li>
        <button className="link" onClick={handleLogout}>
          Logout
        </button>
      </ul>
    </div>
  );
}

export default CustomerNavbar;
