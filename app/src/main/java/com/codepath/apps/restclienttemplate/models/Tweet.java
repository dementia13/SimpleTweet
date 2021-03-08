package com.codepath.apps.restclienttemplate.models;

import androidx.room.Entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {

    private static TimeFormatter timeFormatter;
    public String body;
    public String createdAt;
    public User user;
    public long tweetId;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.tweetId = jsonObject.getLong("id");
        return tweet;
    }

    public static List<Tweet> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

    public static String getFormattedTimestamp(String createdAt){
        return  timeFormatter.getTimeDifference(createdAt);
    }

    /*
    // Use @Embedded to keep column entries as part of the same table while keeping
    // logical sepqration between the objects
    @Embedded
    User user;

    public Tweet(JSONObject object) {
        try {
            this.user = User.parseJSON(object.getJSONObject("user"));
            this.userHandle = object.getString("user_username");
            this.timestamp = object.getString("timestamp");
            this.body = object.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    */

    /*

    public static ArrayList<Tweet> fromJson(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<Tweet>(jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject tweetJson = null;
            try {
                tweetJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Tweet tweet = new Tweet(tweetJson);
            tweets.add(tweet);
        }

        return  tweets;
    }

    */
}
