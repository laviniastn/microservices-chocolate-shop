import React from "react";
import { Route, Navigate } from "react-router-dom";
import { isUserLoggedIn } from "../../services/AuthService";

function AuthRoute() {
  if (isUserLoggedIn()) {
    return <Route {...this.props} />;
  } else {
    return <Navigate to="/login" />;
  }
}

export default AuthRoute;
