import React from "react";
import "./Home.css";
import HomeCarousel from "./components/HomeCarousel";
import HomeCards from "./components/HomeCards";
import { homeCards } from "../../utils/IConstants";

const Home = () => {
  return (
    <div className="home">
      <div className="box1">
        <center>
          <HomeCarousel />
        </center>
      </div>
      <div className="box2">
        <center>
          <HomeCards cards={homeCards} />
        </center>
      </div>
    </div>
  );
};

export default Home;
