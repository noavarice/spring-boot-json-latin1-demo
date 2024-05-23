function fn() {
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  const port = karate.properties['local.server.port']
  return {
    baseUrl: 'http://localhost:' + port,
  };
}
