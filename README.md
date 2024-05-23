# Spring Boot 3.2.5 JSON response charset handling

This is a minimal demo project showing possibly incorrect JSON response charset handling in Spring
Boot Web 3.2.5.

Server start on default port 8080, execute request `GET /api/greetings` as follows:

`curl --verbose http://localhost:8080/api/greetings`

The result looks as follows:

```
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/greetings HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200
< Content-Type: application/json;charset=ISO-8859-1
< Content-Length: 27
< Date: Thu, 23 May 2024 09:17:41 GMT
<
* Connection #0 to host localhost left intact
{"message":"Hello, world!"}%
```

Note: `Content-Type` header value includes ISO-8859-1 charset. AFAIU it's included by embedded
Tomcat server because it's the default charset when nothing is set explicitly (see
`org.apache.coyote.Constants.DEFAULT_BODY_CHARSET`).

The issue reproduces when setting `Content-Type` through `HttpServletResponse` interface directly
when no charset set explicitly (e.g., in any Spring Security handler interface implementation,
such as `AccessDeniedHandler`);
