package com.example.auigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AuiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder,
									 @Value("${aui.planet.url}") String planetUrl,
									 @Value("${aui.star.url}") String starUrl,
									 @Value("${aui.gateway.host}") String host

	){
		return  builder
				.routes()
				.route("stars", route -> route
						.host(host)
						.and()
						.path(
								"/api/stars/{uuid}",
								"/api/stars"
						)
						.uri(starUrl)
				)
				.route("planets",route -> route
						.host(host)
						.and()
						.path(

								"api/planets",
								"/api/planets/**",
								"/api/stars/{uuid}/planets",
								"/api/stars/{uuid}/planets/**"
						)
						.uri(planetUrl)
				)
				.build();
	}
}
