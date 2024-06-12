package com.soumyadeep.Assignment.RemoteApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ConfigurationProperties(prefix = "api")
public class ApiProperties {
    private String url;
    private String token;

}
