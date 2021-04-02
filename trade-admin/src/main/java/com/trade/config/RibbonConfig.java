package com.trade.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
       @Bean
       public IRule ribbonRule(){
           IRule bestAvailableRule = new BestAvailableRule();
           RetryRule retryRule = new RetryRule(bestAvailableRule,15000);
           retryRule.setMaxRetryMillis(20000);

           return retryRule;
       }
}
