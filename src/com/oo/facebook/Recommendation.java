package com.oo.facebook;

import java.util.Date;
import java.util.List;

public class Recommendation {
    private Integer recommendationId;
    private int rating;
    private String description;
    private Date createdAt;

    private List<JobPosting> activePostings;
}
