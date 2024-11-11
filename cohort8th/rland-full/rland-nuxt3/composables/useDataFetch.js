export function useDataFetch(url, options = {}) {
  // jwt 권한 부여받으려면
  // SSR useFetch()
  // CSR $fetch()

  const { token } = useUserDetails();

  options.header = {
    ...options.headers,
    ...(token.value && { Authorization: `Bearer ${token.value}` }),
  };

  const config = useRuntimeConfig();
  return $fetch(`${config.public.apiBase}${url}`, options);
}
