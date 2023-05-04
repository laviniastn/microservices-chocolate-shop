import React from "react";
import "./Registration.css";
import { useFormik } from "formik";

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

const Registration = () => {
  const formik = useFormik({
    initialValues: {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
    },
    validate,
    onSubmit: (values) => {
      alert(JSON.stringify(values, null, 2));
    },
  });

  return (
    <div className="registration">
      <form className="registrationForm" onSubmit={formik.handleSubmit}>
        <p className="center">Create account</p>
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
            id="email"
            name="email"
            className="email"
            type="text"
            placeholder="Enter your email address"
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
            Register
          </button>
        </label>
      </form>
    </div>
  );
};

export default Registration;
