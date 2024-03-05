package com.atguigu.cloud;

import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class GyfRoutePredicateFactory extends AbstractRoutePredicateFactory<GyfRoutePredicateFactory.Config> {

    public GyfRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("gyfName");
    }
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String userName = serverWebExchange.getRequest().getQueryParams().getFirst("gyfName");
                if (userName==null){
                    return false;
                }
                return userName.equalsIgnoreCase(config.getGyfName());
            }
        };
    }

    @Validated
    public static class Config{
        @NotNull
        private String gyfName;

        public String getGyfName() {
            return gyfName;
        }

        public void setGyfName(String gyfName) {
            this.gyfName = gyfName;
        }
    }
}
