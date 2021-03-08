package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

    @Dao
    public interface TwitterDao {

        // @Query annotation requires knowing SQL syntax
        // See http://www.sqltutorial.org/

        // Record finders
        //@Query("SELECT * FROM Tweet WHERE post_id = :tweetId")
        //Tweet byTweetId(long tweetId);

        @Query("SELECT * FROM Tweet ORDER BY timestamp")
        List<Tweet> getRecentTweets();

        /*
        @Query("SELECT * FROM Tweet ORDER BY ID DESC LIMIT 300")
        List<SampleModel> recentItems();
        */

        // Replace strategy is needed to ensure an update on the table row
        // Otherwise the insertion will fail
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertTweet(Tweet...tweets);


}
