const state = reactive({
  userName: null,
  email: null,
  roles: [],
});

const actions = {
  login(userName, userEmail, roles) {
    state.userName = userName;
    state.email = userEmail;
    state.roles = roles;
  },
  logout() {
    state.userName = null;
    state.email = null;
    state.roles = [];
  },
  isAnonymous() {
    return state.userName == null;
  },
};

export default state;
export { actions };
