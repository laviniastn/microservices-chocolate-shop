import "./HomeCards.css";
import HomeCard from "./HomeCard";

const HomeCards = (props) => {
  return (
    <div>
      {props.cards.map((card) => (
        <HomeCard key={card.id} {...card} />
      ))}
    </div>
  );
};

export default HomeCards;
