package dev.brunopaz.gitlabcompletion;

import com.google.gson.annotations.SerializedName;

public class GitLabVariable {

    @SerializedName("Variable")
    private String name;

    @SerializedName("Description")
    private String description;

    @SerializedName("GitLab")
    private String glVersion;

    @SerializedName("Runner")
    private String runnerVersion;

    public String getName() {
        return "$" + name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return glVersion;
    }

    public String getRunner() {
        return runnerVersion;
    }
}
