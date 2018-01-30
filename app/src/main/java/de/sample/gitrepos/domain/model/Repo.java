
package de.sample.gitrepos.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("full_name")
    @Expose
    private String fullName;

    @SerializedName("owner")
    @Expose
    public Owner owner;

    @SerializedName("private")
    @Expose
    private Boolean _private;

    @SerializedName("html_url")
    @Expose
    public String htmlUrl;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("fork")
    @Expose
    public Boolean fork;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("forks_url")
    @Expose
    private String forksUrl;

    @SerializedName("keys_url")
    @Expose
    private String keysUrl;

    @SerializedName("collaborators_url")
    @Expose
    private String collaboratorsUrl;

    @SerializedName("teams_url")
    @Expose
    private String teamsUrl;

    @SerializedName("hooks_url")
    @Expose
    private String hooksUrl;

    @SerializedName("issue_events_url")
    @Expose
    private String issueEventsUrl;

    @SerializedName("events_url")
    @Expose
    private String eventsUrl;

    @SerializedName("assignees_url")
    @Expose
    private String assigneesUrl;

    @SerializedName("branches_url")
    @Expose
    private String branchesUrl;

    @SerializedName("tags_url")
    @Expose
    private String tagsUrl;

    @SerializedName("blobs_url")
    @Expose
    private String blobsUrl;
    @SerializedName("git_tags_url")
    @Expose
    private String gitTagsUrl;

    @SerializedName("git_refs_url")
    @Expose
    private String gitRefsUrl;

    @SerializedName("trees_url")
    @Expose
    private String treesUrl;

    @SerializedName("statuses_url")
    @Expose
    private String statusesUrl;

    @SerializedName("languages_url")
    @Expose
    private String languagesUrl;

    @SerializedName("stargazers_url")
    @Expose
    private String stargazersUrl;

    @SerializedName("contributors_url")
    @Expose
    private String contributorsUrl;

    @SerializedName("subscribers_url")
    @Expose
    private String subscribersUrl;

    @SerializedName("subscription_url")
    @Expose
    private String subscriptionUrl;

    @SerializedName("commits_url")
    @Expose
    private String commitsUrl;

    @SerializedName("git_commits_url")
    @Expose
    private String gitCommitsUrl;

    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;

    @SerializedName("issue_comment_url")
    @Expose
    private String issueCommentUrl;

    @SerializedName("contents_url")
    @Expose
    private String contentsUrl;

    @SerializedName("compare_url")
    @Expose
    private String compareUrl;

    @SerializedName("merges_url")
    @Expose
    private String mergesUrl;

    @SerializedName("archive_url")
    @Expose
    private String archiveUrl;

    @SerializedName("downloads_url")
    @Expose
    private String downloadsUrl;

    @SerializedName("issues_url")
    @Expose
    private String issuesUrl;

    @SerializedName("pulls_url")
    @Expose
    private String pullsUrl;

    @SerializedName("milestones_url")
    @Expose
    private String milestonesUrl;

    @SerializedName("notifications_url")
    @Expose
    private String notificationsUrl;

    @SerializedName("labels_url")
    @Expose
    private String labelsUrl;

    @SerializedName("releases_url")
    @Expose
    private String releasesUrl;

    @SerializedName("deployments_url")
    @Expose
    private String deploymentsUrl;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("pushed_at")
    @Expose
    private String pushedAt;

    @SerializedName("git_url")
    @Expose
    private String gitUrl;

    @SerializedName("ssh_url")
    @Expose
    private String sshUrl;

    @SerializedName("clone_url")
    @Expose
    private String cloneUrl;

    @SerializedName("svn_url")
    @Expose
    private String svnUrl;

    @SerializedName("homepage")
    @Expose
    private String homepage;

    @SerializedName("size")
    @Expose
    private Integer size;

    @SerializedName("stargazers_count")
    @Expose
    private Integer stargazersCount;

    @SerializedName("watchers_count")
    @Expose
    private Integer watchersCount;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("has_issues")
    @Expose
    private Boolean hasIssues;

    @SerializedName("has_projects")
    @Expose
    private Boolean hasProjects;

    @SerializedName("has_downloads")
    @Expose
    private Boolean hasDownloads;

    @SerializedName("has_wiki")
    @Expose
    private Boolean hasWiki;

    @SerializedName("has_pages")
    @Expose
    private Boolean hasPages;

    @SerializedName("forks_count")
    @Expose
    private Integer forksCount;

    @SerializedName("mirror_url")
    @Expose
    private Object mirrorUrl;

    @SerializedName("open_issues_count")
    @Expose
    private Integer openIssuesCount;

    @SerializedName("forks")
    @Expose
    private Integer forks;

    @SerializedName("open_issues")
    @Expose
    private Integer openIssues;

    @SerializedName("watchers")
    @Expose
    private Integer watchers;

    @SerializedName("default_branch")
    @Expose
    private String defaultBranch;

    /**
     * No args constructor for use in serialization.
     */
    public Repo() { }

    /**
     * @param  notificationsUrl
     * @param  releasesUrl
     * @param  pushedAt
     * @param  gitTagsUrl
     * @param  contentsUrl
     * @param  blobsUrl
     * @param  issueEventsUrl
     * @param  htmlUrl
     * @param  _private
     * @param  hooksUrl
     * @param  description
     * @param  commentsUrl
     * @param  commitsUrl
     * @param  labelsUrl
     * @param  assigneesUrl
     * @param  mergesUrl
     * @param  fork
     * @param  compareUrl
     * @param  stargazersUrl
     * @param  gitRefsUrl
     * @param  deploymentsUrl
     * @param  watchersCount
     * @param  openIssuesCount
     * @param  mirrorUrl
     * @param  homepage
     * @param  url
     * @param  size
     * @param  keysUrl
     * @param  gitCommitsUrl
     * @param  milestonesUrl
     * @param  downloadsUrl
     * @param  issueCommentUrl
     * @param  pullsUrl
     * @param  owner
     * @param  forksUrl
     * @param  hasProjects
     * @param  language
     * @param  statusesUrl
     * @param  eventsUrl
     * @param  openIssues
     * @param  teamsUrl
     * @param  sshUrl
     * @param  contributorsUrl
     * @param  stargazersCount
     * @param  tagsUrl
     * @param  id
     * @param  hasIssues
     * @param  createdAt
     * @param  name
     * @param  treesUrl
     * @param  cloneUrl
     * @param  issuesUrl
     * @param  gitUrl
     * @param  forksCount
     * @param  watchers
     * @param  subscriptionUrl
     * @param  svnUrl
     * @param  archiveUrl
     * @param  hasPages
     * @param  languagesUrl
     * @param  updatedAt
     * @param  collaboratorsUrl
     * @param  forks
     * @param  hasDownloads
     * @param  subscribersUrl
     * @param  branchesUrl
     * @param  fullName
     * @param  hasWiki
     * @param  defaultBranch
     */
    public Repo(final Integer id, final String name, final String fullName, final Owner owner, final Boolean _private,
            final String htmlUrl, final String description, final Boolean fork, final String url, final String forksUrl,
            final String keysUrl, final String collaboratorsUrl, final String teamsUrl, final String hooksUrl,
            final String issueEventsUrl, final String eventsUrl, final String assigneesUrl, final String branchesUrl,
            final String tagsUrl, final String blobsUrl, final String gitTagsUrl, final String gitRefsUrl,
            final String treesUrl, final String statusesUrl, final String languagesUrl, final String stargazersUrl,
            final String contributorsUrl, final String subscribersUrl, final String subscriptionUrl,
            final String commitsUrl, final String gitCommitsUrl, final String commentsUrl, final String issueCommentUrl,
            final String contentsUrl, final String compareUrl, final String mergesUrl, final String archiveUrl,
            final String downloadsUrl, final String issuesUrl, final String pullsUrl, final String milestonesUrl,
            final String notificationsUrl, final String labelsUrl, final String releasesUrl,
            final String deploymentsUrl, final String createdAt, final String updatedAt, final String pushedAt,
            final String gitUrl, final String sshUrl, final String cloneUrl, final String svnUrl, final String homepage,
            final Integer size, final Integer stargazersCount, final Integer watchersCount, final String language,
            final Boolean hasIssues, final Boolean hasProjects, final Boolean hasDownloads, final Boolean hasWiki,
            final Boolean hasPages, final Integer forksCount, final Object mirrorUrl, final Integer openIssuesCount,
            final Integer forks, final Integer openIssues, final Integer watchers, final String defaultBranch) {
        super();
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.owner = owner;
        this._private = _private;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.fork = fork;
        this.url = url;
        this.forksUrl = forksUrl;
        this.keysUrl = keysUrl;
        this.collaboratorsUrl = collaboratorsUrl;
        this.teamsUrl = teamsUrl;
        this.hooksUrl = hooksUrl;
        this.issueEventsUrl = issueEventsUrl;
        this.eventsUrl = eventsUrl;
        this.assigneesUrl = assigneesUrl;
        this.branchesUrl = branchesUrl;
        this.tagsUrl = tagsUrl;
        this.blobsUrl = blobsUrl;
        this.gitTagsUrl = gitTagsUrl;
        this.gitRefsUrl = gitRefsUrl;
        this.treesUrl = treesUrl;
        this.statusesUrl = statusesUrl;
        this.languagesUrl = languagesUrl;
        this.stargazersUrl = stargazersUrl;
        this.contributorsUrl = contributorsUrl;
        this.subscribersUrl = subscribersUrl;
        this.subscriptionUrl = subscriptionUrl;
        this.commitsUrl = commitsUrl;
        this.gitCommitsUrl = gitCommitsUrl;
        this.commentsUrl = commentsUrl;
        this.issueCommentUrl = issueCommentUrl;
        this.contentsUrl = contentsUrl;
        this.compareUrl = compareUrl;
        this.mergesUrl = mergesUrl;
        this.archiveUrl = archiveUrl;
        this.downloadsUrl = downloadsUrl;
        this.issuesUrl = issuesUrl;
        this.pullsUrl = pullsUrl;
        this.milestonesUrl = milestonesUrl;
        this.notificationsUrl = notificationsUrl;
        this.labelsUrl = labelsUrl;
        this.releasesUrl = releasesUrl;
        this.deploymentsUrl = deploymentsUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.gitUrl = gitUrl;
        this.sshUrl = sshUrl;
        this.cloneUrl = cloneUrl;
        this.svnUrl = svnUrl;
        this.homepage = homepage;
        this.size = size;
        this.stargazersCount = stargazersCount;
        this.watchersCount = watchersCount;
        this.language = language;
        this.hasIssues = hasIssues;
        this.hasProjects = hasProjects;
        this.hasDownloads = hasDownloads;
        this.hasWiki = hasWiki;
        this.hasPages = hasPages;
        this.forksCount = forksCount;
        this.mirrorUrl = mirrorUrl;
        this.openIssuesCount = openIssuesCount;
        this.forks = forks;
        this.openIssues = openIssues;
        this.watchers = watchers;
        this.defaultBranch = defaultBranch;
    }
}
