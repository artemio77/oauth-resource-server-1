package com.gmail.derevets.artem.config.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterOAuthConfig {

    @Value("${twitter.oauth.consumerKey}")
    private String twitterOAuthConsumerKey;

    @Value("${twitter.oauth.consumerSecret}")
    private String twitterOAuthConsumerSecret;

    @Value("${twitter.oauth.accessToken}")
    private String twitterOAuthToken;

    @Value("${twitter.oauth.accessTokenSecret}")
    private String twitterOAuthTokenSecret;


    @Bean
    public Twitter twitterConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterOAuthConsumerKey)
                .setOAuthConsumerSecret(twitterOAuthConsumerSecret)
                .setOAuthAccessToken(twitterOAuthToken)
                .setOAuthAccessTokenSecret(twitterOAuthTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    @Bean
    public TwitterStream twitterStreamConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterOAuthConsumerKey)
                .setOAuthConsumerSecret(twitterOAuthConsumerSecret)
                .setOAuthAccessToken(twitterOAuthToken)
                .setOAuthAccessTokenSecret(twitterOAuthTokenSecret);
        TwitterStreamFactory twitterStream = new TwitterStreamFactory(cb.build());
        return twitterStream.getInstance();
    }
}
