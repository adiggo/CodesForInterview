/**
 * Created by i843719 on 11/3/14.
 */

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.RestAdapter;
/**
 *
 * @author spannt
 *
 */
public class TestGitHub {
    static final String API_URL = "https://api.github.com";
    static class GithubUserData{
        String avatar_url;
        String bio;
        String blog;
        String company;
        String created_at;
        String email;
        String events_url;
        Number followers;
        String followers_url;
        Number following;
        String following_url;
        String gists_url;
        String gravatar_id;
        boolean hireable;
        String html_url;
        Number id;
        String location;
        String login;
        String name;
        String organizations_url;
        Number public_gists;
        Number public_repos;
        String received_events_url;
        String repos_url;
        String starred_url;
        String subscriptions_url;
        String type;
        String updated_at;
        String url;
    }
    interface GithubUser {
        @GET("/users/{username}")
        GithubUserData user(@Path("username") String username);
    }
    /**
     *
     * @param args
     */
    public static void main(String... args) {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        // Create a very simple REST adapter which points the GitHub API endpoint.
        // Create a very simple REST adapter which points the GitHub API endpoint.
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();

        // Create an instance of our GitHub API interface.
        GithubUser githubUser = restAdapter.create(GithubUser.class);
        GithubUserData userdata = githubUser.user("adiggo");

        System.out.println("UserData=" + userdata.bio + "," + userdata.email + "," + userdata.name +
                userdata.location + "," + userdata.public_repos + "," + userdata.followers);
    }
}