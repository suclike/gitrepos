
package de.sample.gitrepos.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    @Expose
    public String login;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("gravatar_id")
    @Expose
    private String gravatarId;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("html_url")
    @Expose
    public String htmlUrl;

    @SerializedName("followers_url")
    @Expose
    private String followersUrl;

    @SerializedName("following_url")
    @Expose
    private String followingUrl;

    @SerializedName("gists_url")
    @Expose
    private String gistsUrl;

    @SerializedName("starred_url")
    @Expose
    private String starredUrl;

    @SerializedName("subscriptions_url")
    @Expose
    private String subscriptionsUrl;

    @SerializedName("organizations_url")
    @Expose
    private String organizationsUrl;

    @SerializedName("repos_url")
    @Expose
    private String reposUrl;

    @SerializedName("events_url")
    @Expose
    private String eventsUrl;

    @SerializedName("received_events_url")
    @Expose
    private String receivedEventsUrl;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("site_admin")
    @Expose
    private Boolean siteAdmin;

    /**
     * No args constructor for use in serialization.
     */
    public Owner() { }

    /**
     * @param  eventsUrl
     * @param  siteAdmin
     * @param  gistsUrl
     * @param  type
     * @param  gravatarId
     * @param  url
     * @param  subscriptionsUrl
     * @param  id
     * @param  followersUrl
     * @param  reposUrl
     * @param  htmlUrl
     * @param  receivedEventsUrl
     * @param  avatarUrl
     * @param  followingUrl
     * @param  login
     * @param  organizationsUrl
     * @param  starredUrl
     */
    public Owner(final String login, final Integer id, final String avatarUrl, final String gravatarId,
            final String url, final String htmlUrl, final String followersUrl, final String followingUrl,
            final String gistsUrl, final String starredUrl, final String subscriptionsUrl,
            final String organizationsUrl, final String reposUrl, final String eventsUrl,
            final String receivedEventsUrl, final String type, final Boolean siteAdmin) {
        super();
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.gistsUrl = gistsUrl;
        this.starredUrl = starredUrl;
        this.subscriptionsUrl = subscriptionsUrl;
        this.organizationsUrl = organizationsUrl;
        this.reposUrl = reposUrl;
        this.eventsUrl = eventsUrl;
        this.receivedEventsUrl = receivedEventsUrl;
        this.type = type;
        this.siteAdmin = siteAdmin;
    }
}
