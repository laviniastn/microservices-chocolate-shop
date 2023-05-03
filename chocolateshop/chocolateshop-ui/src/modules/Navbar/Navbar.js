import React from "react";
import "./Navbar.css";
import logo from "../../../src/asserts/logo.png";
import cart from "../../../src/asserts/cart.png";

function Navbar() {
  return (
    <div class="navbar">
      <div class="logo">
        <a href="/">
          <img src={logo} alt="" width="30" height="30" />
        </a>
      </div>
      <ul class="navigation">
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
          <a href="/cart">
            <img src={cart} alt="" width="20" height="20" />
          </a>
        </li>
        <li>
          <a href="/contact">Contact</a>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;
