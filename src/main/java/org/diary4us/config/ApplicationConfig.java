package org.diary4us.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.diary4us.web"})
@Import(DBconfig.class)
public class ApplicationConfig {
}
