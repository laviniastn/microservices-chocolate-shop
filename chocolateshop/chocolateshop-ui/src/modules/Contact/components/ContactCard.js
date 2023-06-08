import Card from "react-bootstrap/Card";
import "./ContactCard.css";

const ContactCard = (card) => {
  return (
    <Card className="mycontact">
      <Card.Img className="contactimg" variant="left" src={card.img} />
      <Card.Body className="contactbody">
        <Card.Title className="contacttitle">{card.title}</Card.Title>
      </Card.Body>
    </Card>
  );
};

export default ContactCard;
