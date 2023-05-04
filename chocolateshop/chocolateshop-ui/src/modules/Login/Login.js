import React from "react";
import "./Login.css";
import { useFormik } from "formik";
import { useState, useEffect } from "react";
import { login } from "./../../services/ApiService";

const validate = (values) => {
  const errors = {};

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

const Login = () => {
  const [user, setUser] = useState({});

  const formik = useFormik({
    initialValues: {
      userEmail: "",
      userPassword: "",
    },
    validate,
    onSubmit: async (values) => {
      alert(JSON.stringify(values, null, 2));
      await login(values).then((result) => {
        const userData = result.data;
        setUser(userData);
      });
    },
  });

  useEffect(() => {
    console.log("Login user: " + user.userEmail);
  }, [user]);

  return (
    <div className="login">
      <form className="loginForm" onSubmit={formik.handleSubmit}>
        <p className="center">Sign in to your account</p>
        <label>
          <p className="left">Email:</p>
          <input
            className="email"
            id="userEmail"
            name="userEmail"
            type="email"
            placeholder="Enter your email"
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
            Submit
          </button>
        </label>
      </form>
    </div>
  );
};

export default Login;
