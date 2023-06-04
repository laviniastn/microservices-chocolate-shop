export const USER_SESSION_ATTRIBUTE_EMAIL = "authenticatedUser";
export const USER_SESSION_ATTRIBUTE_ROLE = "authenticatedUserRole";

function registerSuccessfulLogin(username, role) {
  sessionStorage.setItem(USER_SESSION_ATTRIBUTE_EMAIL, username);
  sessionStorage.setItem(USER_SESSION_ATTRIBUTE_ROLE, role);
}

function logout() {
  sessionStorage.removeItem(USER_SESSION_ATTRIBUTE_EMAIL);
  sessionStorage.removeItem(USER_SESSION_ATTRIBUTE_ROLE);
}

function isUserLoggedIn() {
  let user = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_EMAIL);
  if (user === null || user === "") return false;
  return true;
}

function hasUserLoggedInAdminRole() {
  let role = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_ROLE);
  if (role === "ROLE_ADMIN") return true;
  return false;
}

function hasUserLoggedInCustomerRole() {
  let role = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_ROLE);
  if (role === "ROLE_CUSTOMER") return true;
  return false;
}

function hasUserLoggedInSellerRole() {
  let role = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_ROLE);
  if (role === "ROLE_SELLER") return true;
  return false;
}

function getLoggedInUserEmail() {
  let user = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_EMAIL);
  if (user === null) return "";
  return user;
}

function getLoggedInUserRole() {
  let role = sessionStorage.getItem(USER_SESSION_ATTRIBUTE_ROLE);
  if (role === null) return "";
  return role;
}

export {
  registerSuccessfulLogin,
  logout,
  isUserLoggedIn,
  getLoggedInUserEmail,
  getLoggedInUserRole,
  hasUserLoggedInSellerRole,
  hasUserLoggedInAdminRole,
  hasUserLoggedInCustomerRole,
};
