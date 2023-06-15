import React from "react";
import Table from "react-bootstrap/Table";
import "./UsersTable.css";
import { deleteUserById, getAllUsers } from "../../../services/ApiService";
import { useState, useEffect } from "react";

const UsersTable = () => {
  const [tableUsers, setTableUsers] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      const result = await getAllUsers();
      setTableUsers(result.data);
    };

    fetchData();
  }, []);

  const deleteUser = (id) => {
    const filterTableUsers = tableUsers.filter((item) => item.id !== id);
    setTableUsers(filterTableUsers);
    deteleUserCall(id);
  };

  const deteleUserCall = async (id) => {
    await deleteUserById(id);
  };

  return (
    <div className="userstable">
      <h5>Users Table</h5>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Role</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {tableUsers?.map((d) => (
            <tr key={d.id}>
              <td>{d.id}</td>
              <td>{d.firstName}</td>
              <td>{d.lastName}</td>
              <td>{d.userEmail}</td>
              <td>{d.roles[0].roleName}</td>
              <td>
                <button className="delbutton" onClick={() => deleteUser(d.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default UsersTable;
