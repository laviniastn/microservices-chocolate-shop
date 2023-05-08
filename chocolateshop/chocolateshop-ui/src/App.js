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
import Products from "./modules/Products/Products";
import Users from "./modules/Users/Users";
import Inventory from "./modules/Inventory/Inventory";
import AdminNavbar from "./modules/Navbar/AdminNavbar";
import SellerNavbar from "./modules/Navbar/SellerNavbar";
import {
  isUserLoggedIn,
  getLoggedInUserEmail,
  registerSuccessfulLogin,
  getLoggedInUserRole,
  hasUserLoggedInCustomerRole,
  hasUserLoggedInAdminRole,
  hasUserLoggedInSellerRole,
} from "./services/AuthService";
import { useState, useEffect } from "react";

function App() {
  const [userLogged] = useState(isUserLoggedIn() === true);

  const [userLoggedEmail, setUserLoggedEmail] = useState(
    getLoggedInUserEmail()
  );
  const [userLoggedRole, setUserLoggedRole] = useState(getLoggedInUserRole());

  useEffect(() => {
    if (userLogged === true) setUserLoggedEmail(getLoggedInUserEmail());
  }, [userLogged]);

  useEffect(() => {
    if (userLogged === true) setUserLoggedRole(getLoggedInUserRole());
  }, [userLogged]);

  useEffect(() => {
    if (userLogged === true)
      registerSuccessfulLogin(userLoggedEmail, userLoggedRole);
  }, [userLogged, userLoggedEmail, userLoggedRole]);

  return (
    <BrowserRouter>
      {isUserLoggedIn() === false && <Navbar />}

      {isUserLoggedIn() === true && hasUserLoggedInCustomerRole() === true && (
        <CustomerNavbar />
      )}

      {isUserLoggedIn() === true && hasUserLoggedInAdminRole() === true && (
        <AdminNavbar />
      )}

      {isUserLoggedIn() === true && hasUserLoggedInSellerRole() === true && (
        <SellerNavbar />
      )}

      <Routes>
        {isUserLoggedIn() === false && <Route path="/" element={<Home />} />}

        {isUserLoggedIn() === false && (
          <Route path="/login" element={<Login />} />
        )}

        {isUserLoggedIn() === false && (
          <Route path="/registration" element={<Registration />} />
        )}

        <Route path="/contact" element={<Contact />} />

        {isUserLoggedIn() === true &&
          hasUserLoggedInCustomerRole() === true && (
            <Route path="/customer" element={<Customer />} />
          )}

        {isUserLoggedIn() === true &&
          hasUserLoggedInCustomerRole() === true && (
            <Route path="/cart" element={<Cart />} />
          )}

        {isUserLoggedIn() === true &&
          hasUserLoggedInCustomerRole() === true && (
            <Route path="/products" element={<Products />} />
          )}

        {isUserLoggedIn() === true && hasUserLoggedInAdminRole() === true && (
          <Route path="/admin" element={<Admin />} />
        )}

        {isUserLoggedIn() === true && hasUserLoggedInAdminRole() === true && (
          <Route path="/users" element={<Users />} />
        )}

        {isUserLoggedIn() === true && hasUserLoggedInSellerRole() === true && (
          <Route path="/seller" element={<Seller />} />
        )}

        {isUserLoggedIn() === true && hasUserLoggedInSellerRole() === true && (
          <Route path="/inventory" element={<Inventory />} />
        )}
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
