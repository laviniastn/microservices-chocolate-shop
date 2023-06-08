import React from "react";
import "./AdminNavbar.css";
import logo from "../../../src/asserts/logo.png";
import { logout } from "../../services/AuthService";
import { useNavigate } from "react-router-dom";
import { isUserLoggedIn } from "../../services/AuthService";

import { useState } from "react";

function AdminNavbar() {
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
          <a href="/users">Users</a>
        </li>
        <li>
          <a href="/admin">Profile</a>
        </li>
        <li>
          <button className="link" onClick={handleLogout}>
            Logout
          </button>
        </li>
      </ul>
    </div>
  );
}

export default AdminNavbar;
