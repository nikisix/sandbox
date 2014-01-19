/**
 * Created by zen on 1/10/14.
 */

import twitter4j._
import twitter4j.conf.ConfigurationBuilder

object TwitterOauth {
  def main(args: Array[String]) {
    val consumerKey = "wkzcX2MqCkyjRdoSzIlYA"
    val consumerSecret = "Bq84T8IbJeLyBFNsuRp8zgMkL3WEihCEyigHVvGr5k"
    val accessToken = "43985865-pUx7jvuyJZJKGDFAqaMlB7K8DJ30d1pCtqrx8aHXY"
    val accessTokenSecret = "L1lOKurkNP0ohhS29e9xif8Tguc9rWuPacYExietgrAGM"

    val cb : ConfigurationBuilder = new ConfigurationBuilder
    cb.setOAuthConsumerKey(consumerKey)
    cb.setOAuthConsumerSecret(consumerSecret)
    cb.setOAuthAccessToken(accessToken)
    cb.setOAuthAccessTokenSecret(accessTokenSecret)

    //must Oauth with twitter api v1.1
    val factory: TwitterFactory = new TwitterFactory(cb.build)
    val twitter: Twitter = factory.getInstance

    val query: Query = new Query("#49ers")
    val result: QueryResult = twitter.search(query)

    val tweets: java.util.List[Status] = result.getTweets
    val iter = tweets.iterator

    while(iter.hasNext) {
      println(iter.next)
    }
//    result.getTweets.foreach(status: Status => System.out.println("@" + status.getUser.getScreenName + ":" + status.getText) )
//    println(result.getTweets.toString)

    if(result.getTweets.isEmpty || result.getTweets.size < 1) {
      println("no results :(")
      return
    }
  }
}
