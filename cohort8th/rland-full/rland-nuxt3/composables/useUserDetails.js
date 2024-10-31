export default () => {
  const id = useState("id", () => null);
  const userName = useState("userName", () => null);
  const email = useState("email", () => null);
  const roles = useState("roles", () => []);

  const isAnonymous = () => {
    return userName.value === null;
  };

  const login = (loginInfo) => {
    id.value = loginInfo.id;
    userName.value = loginInfo.userName;
    email.value = loginInfo.email;
    roles.value = loginInfo.roles;
  };

  const logout = () => {
    id.value = null;
    userName.value = null;
    email.value = null;
    roles.value = [];
  };

  return {
    id,
    userName,
    email,
    roles,
    isAnonymous,
    login,
    logout,
  };
};
