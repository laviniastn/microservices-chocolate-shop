import React from "react";
import "./Navbar.css";
import logo from "../../../src/asserts/logo.png";

function Navbar() {
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
          <a href="/login">Login</a>
        </li>
        <li>
          <a href="/registration">Registration</a>
        </li>
        <li>
          <a href="/contact">Contact</a>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;
