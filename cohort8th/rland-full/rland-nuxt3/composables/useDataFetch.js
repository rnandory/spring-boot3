export function useDataFetch(url, options = {}) {
  const config = useRuntimeConfig();
  return $fetch(`${config.public.apiBase}${url}`, options);
}
