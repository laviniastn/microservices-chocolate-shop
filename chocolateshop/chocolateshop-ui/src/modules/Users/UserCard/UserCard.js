import Card from "react-bootstrap/Card";
import "./UserCard.css";

const UserCard = (data) => {
  return (
    <Card className="myuser">
      <Card.Img className="userimg" variant="top" src={data.user?.image} />
      <Card.Body className="userbody">
        <Card.Title className="usertitle">
          {data.user?.details.roles[0].roleName}
        </Card.Title>
        <Card.Text className="usertext">
          <div>
            <b> Name: </b>
            {data.user?.details.firstName + " " + data.user?.details.lastName}
          </div>
          <div>
            <b> Email: </b> {data.user?.details.userEmail}
          </div>
        </Card.Text>
      </Card.Body>
    </Card>
  );
};

export default UserCard;
