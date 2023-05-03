import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./modules/Login/Login";
import Navbar from "./modules/Navbar/Navbar";
import Home from "./modules/Home/Home";
import Registration from "./modules/Registration/Registration";
import Contact from "./modules/Contact/Contact";
import Cart from "./modules/Cart/Cart";
import Footer from "./modules/Footer/Footer";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/cart" element={<Cart />} />
        {/* <Route path = "/meal/:id" element = {<MealDetails />} />
        <Route path = "/meal/category/:name" element = {<Category />} />
        <Route path  = "*" element = {<Error />} /> */}
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
