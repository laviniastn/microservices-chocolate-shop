import slide1 from "../../../../src/asserts/home/slide1.JPG";
import slide2 from "../../../../src/asserts/home/slide2.JPG";
import slide3 from "../../../../src/asserts/home/slide3.JPG";
import { Carousel } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "./HomeCarousel.css";

const HomeCarousel = () => {
  return (
    <div className="homeCarousel">
      <Carousel>
        <Carousel.Item>
          <img className="d-block w-100" src={slide1} alt="First slide" />
        </Carousel.Item>
        <Carousel.Item>
          <img className="d-block w-100" src={slide2} alt="Second slide" />
        </Carousel.Item>
        <Carousel.Item>
          <img className="d-block w-100" src={slide3} alt="Third slide" />
        </Carousel.Item>
      </Carousel>
    </div>
  );
};

export default HomeCarousel;
