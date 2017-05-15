package com.quickrental.restful;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by MF Fazeel Mohamed on 5/14/2017.
 */

@ConfigurationProperties(prefix = "app")
@Component
public class AppConfig {

    private String secret;

    private long tokenValidityInSeconds;

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getTokenValidityInSeconds() {
        return this.tokenValidityInSeconds;
    }

    public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
        this.tokenValidityInSeconds = tokenValidityInSeconds;
    }

}
