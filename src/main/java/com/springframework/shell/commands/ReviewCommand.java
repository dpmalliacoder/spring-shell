package com.springframework.shell.commands;

import com.springframework.shell.model.ProductReviewResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.Availability;
import org.springframework.shell.AvailabilityProvider;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;
import org.springframework.web.client.RestClient;

@Command
public class ReviewCommand {
    Logger logger = LoggerFactory.getLogger(ReviewCommand.class);
    private final RestClient restClient;
    private final ApplicationContext context;

    @Value("${command.available}")
    private boolean connected;

    public ReviewCommand(RestClient restClient, ApplicationContext context) {
        this.restClient = restClient;
        this.context = context;
    }

    @Command(command = "review")
    @CommandAvailability(provider = "checkAvailability")
    public ProductReviewResponse reviews(
            @Option(longNames =  "arg", defaultValue = "1") String productId
    ){
        logger.info("Request for product review {}", productId);
        return getRating(Integer.parseInt(productId));
    }

    private ProductReviewResponse getRating(int productId) {
        logger.info("Rest api executed");
        return this.restClient
                .get()
                .uri("{productId}", productId)
                .headers(httpHeaders -> {
                    httpHeaders.add("Accept", "application/json");
                    httpHeaders.add("Content-Type", "application/json");
                })
                .retrieve()
                .body(ProductReviewResponse.class);
    }

    @Bean
    public AvailabilityProvider checkAvailability(){
        return () -> connected
                ? Availability.available()
                : Availability.unavailable("you are not connected");
    }

    @Command(command = "exit")
    public void exit(){
        System.exit(SpringApplication.exit(context,  () -> 0));
    }
}
