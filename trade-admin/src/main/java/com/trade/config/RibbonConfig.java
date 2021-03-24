package com.trade.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
       @Bean
       public IRule ribbonRule(){
           RetryRule retryRule = new RetryRule();
           //设置一个最长重试时间
           retryRule.setMaxRetryMillis(5000);
           return retryRule;
       }
}
