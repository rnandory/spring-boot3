export function useDataFetch(url, options = {}) {
  // jwt 권한 부여받으려면
  // SSR useFetch()
  // CSR $fetch()

  const config = useRuntimeConfig();
  return $fetch(`${config.public.apiBase}${url}`, options);
}
