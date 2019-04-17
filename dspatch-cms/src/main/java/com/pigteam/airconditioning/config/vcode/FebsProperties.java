package com.pigteam.airconditioning.config.vcode;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "febs")
@Data
public class FebsProperties {

    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

}
