package com.codepath.apps.restclienttemplate.models;

import androidx.room.ColumnInfo;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    @ColumnInfo
    public String name;
    public String screenName;
    public String publicImageUrl;

    // normally this field would be annotated @PrimaryKey because this is an embedded object
    // it is not needed
    @ColumnInfo
    Long twitter_id;

    // Parse model from JSON
    public static User parseJSON(JSONObject tweetJson) {

        User user = new User();
        //this.twitter_id = tweetJson.getLong("id");
       // this.name = tweetJson.getString("name");
        return user;
    }

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.publicImageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }
}
