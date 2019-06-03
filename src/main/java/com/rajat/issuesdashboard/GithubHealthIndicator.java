package com.rajat.issuesdashboard;

import com.rajat.issuesdashboard.github.GithubClient;
import com.rajat.issuesdashboard.github.RepositoryEvent;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GithubHealthIndicator implements HealthIndicator {

    private final GithubClient githubClient;

    public GithubHealthIndicator(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @Override
    public Health health() {
        try {
            ResponseEntity<RepositoryEvent[]> response = this.githubClient.fetchEvents("spring-projects", "spring-boot");
            if (response.getStatusCode().is2xxSuccessful()) {
                return Health.up().build();
            } else {
                return Health.down().build();
            }
        } catch (Exception ex) {
            return Health.down(ex).build();
        }
    }
}
