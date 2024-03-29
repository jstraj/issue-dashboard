package com.rajat.issuesdashboard.events;

import com.rajat.issuesdashboard.github.GithubClient;
import com.rajat.issuesdashboard.github.RepositoryEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class EventsController {

    private final GithubProjectRepository repository;

    private final GithubClient githubClient;

    public EventsController(GithubProjectRepository repository, GithubClient githubClient) {
        this.repository = repository;
        this.githubClient = githubClient;
    }

    @GetMapping("/events/{repoName}")
    @ResponseBody
    public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
        GithubProject project = this.repository.findByRepoName(repoName);
        System.out.println(project);
        return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("projects", this.repository.findAll());
        return "admin";
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        Iterable<GithubProject> projects = this.repository.findAll();
        List<DashboardEntry> entries = StreamSupport.stream(projects.spliterator(), true)
                .map(p -> new DashboardEntry(p, this.githubClient.fetchEventsList(p.getOrgName(), p.getRepoName())))
                .collect(Collectors.toList());

        model.addAttribute("entries", entries);
        return "dashboard";
    }
}
