package com.rajat.issuesdashboard.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GithubProject implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String orgName;

    @Column(unique = true)
    private String repoName;

    public GithubProject() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    @Override
    public String toString() {
        return "Github Project{" +
                "id=" + id +
                ", orgName='" + orgName + "'" +
                ", repoName='" + repoName + "'" +
                "}";
    }
}
