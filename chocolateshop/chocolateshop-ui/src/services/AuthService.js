export const USER_SESSION_ATTRIBUTE_EMAIL = "authenticatedUser";

function registerSuccessfulLogin(username) {
  sessionStorage.setItem(USER_SESSION_ATTRIBUTE_EMAIL, username);
}

function logout() {
  sessionStorage.removeItem(USER_SESSION_ATTRIBUTE_EMAIL);
}

function isUserLoggedIn() {
  let user = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_EMAIL);
  console.log(user);
  if (user === null || user === "") return false;
  return true;
}

function getLoggedInUserEmail() {
  let user = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_EMAIL);
  if (user === null) return "";
  return user;
}

export {
  registerSuccessfulLogin,
  logout,
  isUserLoggedIn,
  getLoggedInUserEmail,
};
