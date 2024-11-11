export default () => {
  const id = useState("id", () => null);
  const username = useState("username", () => null);
  const email = useState("email", () => null);
  const roles = useState("roles", () => []);
  const token = useState("token", () => []);

  const isAnonymous = () => {
    return username.value === null;
  };

  const setAuthentication = (loginInfo) => {
    id.value = loginInfo.id;
    username.value = loginInfo.username;
    email.value = loginInfo.email;
    roles.value = loginInfo.roles;
    token.value = loginInfo.token;

    // 로컬스토리지는 브라우저에만 있기에 ssr과정에서는 실행되면 안됨
    if (!import.meta.env.SSR) {
      localStorage.setItem("id", loginInfo.id);
      localStorage.setItem("username", loginInfo.username);
      localStorage.setItem("email", loginInfo.email);
      // 로컬스토리지엔 배열 저장불가. 문자열로 바꿔서 저장. [] -> "[]"
      // 이게 싫으면 loginInfo 자체를 문자열로 변환해서 로컬스토리지에 저장해도됨
      localStorage.setItem("roles", JSON.stringify(loginInfo.roles));
      localStorage.setItem("token", loginInfo.token);
    }
  };

  // 새로고침 시 컴포저블이 날아가므로 localStorage에서 다시 읽어와라. 새로고침 -> plugin
  const loadUserFromStorage = () => {
    if (!import.meta.env.SSR) {
      if (!localStorage.getItem("username")) return;

      id.value = localStorage.getItem("id");
      username.value = localStorage.getItem("username");
      email.value = localStorage.getItem("email");
      roles.value = JSON.parse(localStorage.getItem("roles")); // 로컬스토리지엔 문자열로 "[]"저장되어있어서 다시 배열로 바꿔줌
      token.value = localStorage.getItem("token");
    }
  };

  const logout = () => {
    id.value = null;
    username.value = null;
    email.value = null;
    roles.value = [];
    token.value = null;
  };

  const hasRole = (role) => roles.value.includes(role);

  return {
    id,
    username,
    email,
    roles,
    token,
    isAnonymous,
    setAuthentication,
    logout,
    hasRole,
    loadUserFromStorage,
  };
};
