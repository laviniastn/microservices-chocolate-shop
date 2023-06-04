import "./HomeCards.css";
import HomeCard from "./HomeCard";

const HomeCards = (props) => {
  return (
    <div>
      {console.log(props.cards)}
      {props.cards.map((card) => (
        <HomeCard key={card.id} {...card} />
      ))}
    </div>
  );
};

export default HomeCards;
