package com.lampp.project.common.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageResourceConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageResource());
        return bean;
    }

    @Bean
    public MessageSource messageResource() {
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("classpath:messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }

}
