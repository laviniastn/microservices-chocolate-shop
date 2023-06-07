import ContactCard from "./ContactCard";
import "./ContactCards.css";

const ContactCards = (props) => {
  return (
    <div>
      <div className="contact">
        {props.cards.map((card) => (
          <ContactCard key={card.id} {...card} />
        ))}
      </div>
    </div>
  );
};

export default ContactCards;
