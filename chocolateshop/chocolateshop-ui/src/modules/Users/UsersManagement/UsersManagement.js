import React from "react";
import UsersTable from "./UsersTable";
import "./UsersManagement.css";

const UsersManagement = () => {
  return (
    <div className="usersmanagement">
      <center>
        <UsersTable />
      </center>
    </div>
  );
};

export default UsersManagement;
