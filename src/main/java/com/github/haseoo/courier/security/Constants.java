package com.github.haseoo.courier.security;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Constants {
    public static final String RESPONSE_WITH_UNAUTH_ERROR = "Responding with unauthorized error. Message - {}";
    public static final String AUTH_HEADER = "Authorization";
    public static final String BEARER_TOKEN_BEGIN = "Bearer ";

    public static String[] getUnprotectedEndpoints() {
        return new String[]{"/swagger-ui.html", "/h2-console/**", "/login"};
    }
}
