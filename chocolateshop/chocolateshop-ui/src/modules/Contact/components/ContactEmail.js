import { useFormik } from "formik";
import "./ContactEmail.css";

const validate = (values) => {
  const errors = {};

  if (!values.message) {
    errors.message = "Message required";
  } else if (values.message.length < 5) {
    errors.message = "Must be 5 characters at least";
  }

  if (!values.userEmail) {
    errors.userEmail = "Email required";
  } else if (
    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.userEmail)
  ) {
    errors.userEmail = "Invalid email address";
  }

  return errors;
};

const ContactEmail = () => {
  const formik = useFormik({
    initialValues: {
      userEmail: "",
      message: "",
    },
    validate,
    onSubmit: async (values) => {
      alert(JSON.stringify(values, null, 2));
    },
  });

  return (
    <div className="contactEmail">
      <form className="contactForm" onSubmit={formik.handleSubmit}>
        <p className="center">Contact us</p>
        <label>
          <p className="left">Your Email:</p>
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
          <p>Message:</p>
          <textarea
            id="message"
            name="message"
            className="msg"
            type="text"
            placeholder="Enter your message"
            onChange={formik.handleChange}
            value={formik.values.message}
          />
        </label>

        <p className="errors">
          {formik.errors.message ? <div>{formik.errors.message}</div> : null}
        </p>

        <label>
          <button className="button" type="submit">
            Send
          </button>
        </label>
      </form>
    </div>
  );
};

export default ContactEmail;
