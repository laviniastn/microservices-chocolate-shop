import React from "react";
import "./Contact.css";
import ContactCards from "./components/ContactCards";
import { contactCards } from "../../utils/IConstants";
import ContactEmail from "./components/ContactEmail";

const Contact = () => {
  return (
    <div className="contact">
      <div className="contactbox1">
        <div className="address">
          Address: 13th Street. 47 W 13th St, New York, NY 10011, USA
        </div>
        <div className="phone"> Phone: +212-456-7890</div>
        <center>
          <div className="title">Meet the chefs</div>
          <ContactCards cards={contactCards} />
        </center>
      </div>
      <div className="contactbox1">
        <center>
          <ContactEmail />
        </center>
      </div>
    </div>
  );
};

export default Contact;
