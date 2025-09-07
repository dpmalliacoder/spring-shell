package com.springframework.shell.model;

import java.util.List;

public record ProductReviewResponse (List<ReviewResponse> reviews, double ratingInAverage){
}
