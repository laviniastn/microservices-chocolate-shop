import React from "react";
import "./Login.css";
import { useFormik } from "formik";

const validate = (values) => {
  const errors = {};

  if (!values.password) {
    errors.password = "Required";
  } else if (values.password.length < 5) {
    errors.password = "Must be 5 characters at least";
  }

  if (!values.email) {
    errors.email = "Required";
  } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
    errors.email = "Invalid email address";
  }

  return errors;
};

const Login = () => {
  const formik = useFormik({
    initialValues: {
      email: "",
      password: "",
    },
    validate,
    onSubmit: (values) => {
      alert(JSON.stringify(values, null, 2));
    },
  });

  return (
    <div className="login">
      <form className="loginForm" onSubmit={formik.handleSubmit}>
        <p className="center">Sign in to your account</p>
        <label>
          <p className="left">Email:</p>
          <input
            className="email"
            id="email"
            name="email"
            type="email"
            placeholder="Enter your email"
            onChange={formik.handleChange}
            value={formik.values.email}
          />
        </label>

        <p className="errors">
          {formik.errors.email ? <div>{formik.errors.email}</div> : null}
        </p>

        <label>
          <p>Password:</p>
          <input
            id="password"
            name="password"
            className="pwd"
            type="password"
            placeholder="Enter your password"
            onChange={formik.handleChange}
            value={formik.values.password}
          />
        </label>

        <p className="errors">
          {formik.errors.password ? <div>{formik.errors.password}</div> : null}
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
