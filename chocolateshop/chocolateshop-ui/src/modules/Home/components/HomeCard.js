import Card from "react-bootstrap/Card";
import "./HomeCard.css";

const HomeCard = (card) => {
  return (
    <div className="card">
      <Card>
        <Card.Img className="img" variant="top" src={card.img} />
        <Card.Body className="body">
          <Card.Title className="title">{card.title}</Card.Title>
          <Card.Text className="text">{card.text}</Card.Text>
          <a href={card.link}>
            <button className="button">More Details</button>
          </a>
        </Card.Body>
      </Card>
    </div>
  );
};

export default HomeCard;
