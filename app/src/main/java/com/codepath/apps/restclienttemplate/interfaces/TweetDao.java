package com.codepath.apps.restclienttemplate.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.TweetWithUser;
import com.codepath.apps.restclienttemplate.models.User;

import java.util.List;

    @Dao
    public interface TweetDao {

        //@Query("SELECT * FROM Tweet ORDER BY createdAt DESC LIMIT 300")
        //List<TweetWithUser> recentItems();

        // Record finders
        //@Query("SELECT * FROM Tweet WHERE post_id = :tweetId")
        //Tweet byTweetId(long tweetId);

        @Query("SELECT Tweet.body AS tweet_body, Tweet.createdAt AS tweet_createdAt, Tweet.tweetId AS tweet_tweetId, User.* FROM Tweet INNER JOIN User ON userId = User.id ORDER BY createdAt DESC LIMIT 5")
        List<TweetWithUser> recentItems();

        // Replace strategy is needed to ensure an update on the table row
        // Otherwise the insertion will fail
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertModel(Tweet... tweets);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertModel(User... users);

}
