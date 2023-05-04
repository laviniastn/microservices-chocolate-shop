import React from "react";
import "./Registration.css";
import { useFormik } from "formik";
import { useState, useEffect } from "react";
import { createUser } from "./../../services/ApiService";

const validate = (values) => {
  const errors = {};

  if (!values.firstName) {
    errors.firstName = "Required";
  } else if (values.firstName.length < 3) {
    errors.firstName = "Must be 3 characters at least";
  }
  if (!values.lastName) {
    errors.lastName = "Required";
  } else if (values.lastName.length < 3) {
    errors.lastName = "Must be 3 characters at least";
  }

  if (!values.userPassword) {
    errors.userPassword = "Required";
  } else if (values.userPassword.length < 5) {
    errors.userPassword = "Must be 5 characters at least";
  }

  if (!values.userEmail) {
    errors.userEmail = "Required";
  } else if (
    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.userEmail)
  ) {
    errors.userEmail = "Invalid email address";
  }

  return errors;
};

const Registration = () => {
  const [user, setUser] = useState({});

  const formik = useFormik({
    initialValues: {
      firstName: "",
      lastName: "",
      userEmail: "",
      userPassword: "",
      roles: [
        {
          id: 1,
          roleName: "ROLE_CUSTOMER",
        },
      ],
    },
    validate,
    onSubmit: async (values) => {
      values.roles = [
        {
          id: 1,
          roleName: "ROLE_CUSTOMER",
        },
      ];
      alert(JSON.stringify(values, null, 2));
      await createUser(values).then((result) => {
        const userData = result.data;
        setUser(userData);
      });
    },
  });

  useEffect(() => {
    console.log("Registrated user: " + user.userEmail);
  }, [user]);

  return (
    <div className="registration">
      <form className="registrationForm" onSubmit={formik.handleSubmit}>
        <p className="center">Create customer account</p>
        <label>
          <p className="left">First Name:</p>
          <input
            id="firstName"
            name="firstName"
            className="firstName"
            type="text"
            placeholder="Enter your first name"
            onChange={formik.handleChange}
            value={formik.values.firstName}
          />
        </label>
        <p className="errors">
          {formik.errors.firstName ? (
            <div>{formik.errors.firstName}</div>
          ) : null}
        </p>
        <label>
          <p className="left">Last Name:</p>
          <input
            id="lastName"
            name="lastName"
            className="lastName"
            type="text"
            placeholder="Enter your last name"
            onChange={formik.handleChange}
            value={formik.values.lastName}
          />
        </label>
        <p className="errors">
          {formik.errors.lastName ? <div>{formik.errors.lastName}</div> : null}
        </p>
        <label>
          <p className="left">Email:</p>
          <input
            id="userEmail"
            name="userEmail"
            className="email"
            type="text"
            placeholder="Enter your email address"
            onChange={formik.handleChange}
            value={formik.values.userEmail}
          />
        </label>
        <p className="errors">
          {formik.errors.userEmail ? (
            <div>{formik.errors.userEmail}</div>
          ) : null}
        </p>
        <label>
          <p>Password:</p>
          <input
            id="userPassword"
            name="userPassword"
            className="pwd"
            type="password"
            placeholder="Enter your password"
            onChange={formik.handleChange}
            value={formik.values.userPassword}
          />
        </label>
        <p className="errors">
          {formik.errors.userPassword ? (
            <div>{formik.errors.userPassword}</div>
          ) : null}
        </p>
        <label>
          <button className="button" type="submit">
            Register
          </button>
        </label>
      </form>
    </div>
  );
};

export default Registration;
