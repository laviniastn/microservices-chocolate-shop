import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./modules/Login/Login";
import Navbar from "./modules/Navbar/Navbar";
import CustomerNavbar from "./modules/Navbar/CustomerNavbar";
import Home from "./modules/Home/Home";
import Registration from "./modules/Registration/Registration";
import Contact from "./modules/Contact/Contact";
import Cart from "./modules/Cart/Cart";
import Footer from "./modules/Footer/Footer";
import Customer from "./modules/Users/Customer/Customer";
import Admin from "./modules/Users/Admin/Admin";
import Seller from "./modules/Users/Seller/Seller";
import {
  isUserLoggedIn,
  getLoggedInUserEmail,
  registerSuccessfulLogin,
} from "./services/AuthService";
import { useState, useEffect } from "react";

function App() {
  const [userLogged] = useState(isUserLoggedIn() === true);
  const [userLoggedEmail, setUserLoggedEmail] = useState(
    getLoggedInUserEmail()
  );

  useEffect(() => {
    if (userLogged === true) setUserLoggedEmail(getLoggedInUserEmail());
  }, [userLogged]);

  useEffect(() => {
    if (userLogged === true) registerSuccessfulLogin(userLoggedEmail);
  }, [userLogged, userLoggedEmail]);

  return (
    <BrowserRouter>
      {console.log(isUserLoggedIn())}
      {isUserLoggedIn() === false && <Navbar />}
      {isUserLoggedIn() === true && <CustomerNavbar />}

      <Routes>
        <Route path="/" element={<Home />} />
        {isUserLoggedIn() === false && (
          <Route path="/login" element={<Login />} />
        )}

        {isUserLoggedIn() === false && (
          <Route path="/registration" element={<Registration />} />
        )}

        <Route path="/contact" element={<Contact />} />

        {isUserLoggedIn() === true && (
          <Route path="/customer" element={<Customer />} />
        )}
        {isUserLoggedIn() === true && (
          <Route path="/admin" element={<Admin />} />
        )}

        {isUserLoggedIn() === true && (
          <Route path="/seller" element={<Seller />} />
        )}

        {isUserLoggedIn() === true && <Route path="/cart" element={<Cart />} />}
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
