package com.springframework.shell.model;

public record ReviewResponse(Integer productId, String comment, int rating, String userName) {
}
