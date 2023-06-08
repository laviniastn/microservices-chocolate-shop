import React from "react";
import UserCard from "../UserCard/UserCard";
import { getLoggedInUserEmail } from "../../../services/AuthService";
import { findUserByEmail } from "../../../services/ApiService";
import { useState, useEffect } from "react";
import img from "../../../asserts/users/seller.png";

const Seller = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      const result = await findUserByEmail(getLoggedInUserEmail());
      const userData = {
        image: img,
        details: result.data,
      };
      setUser(userData);
    };

    fetchData();
  }, []);

  return (
    <div>
      <center>
        <UserCard user={user} />
      </center>
    </div>
  );
};

export default Seller;
