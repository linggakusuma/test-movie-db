package com.lingga.testmoviedb.utils

import com.lingga.testmoviedb.core.data.source.remote.response.AuthorDetailResponse
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review

object FakeDataDummy {

    fun generateDummyMovies(): List<Movie> {
        val movies = ArrayList<Movie>()

        movies.add(
            Movie(
                id = 527774,
                title = "Raya and the Last Dragon",
                overview = "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                isFavorite = false,
                posterPath = "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                releaseDate = "2021-03-03"
            )
        )
        return movies
    }

    fun generateDummyMovie() = Movie(
        id = 527774,
        title = "Raya and the Last Dragon",
        overview = "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
        isFavorite = false,
        posterPath = "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
        releaseDate = "2021-03-03"
    )

    fun generateDummyReviews(id: Int): List<Review> {
        val reviews = ArrayList<Review>()
        val authorDetail = AuthorDetailResponse(
            username = "",
            avatarPath = "/https://secure.gravatar.com/avatar/3593437cbd05cebe0a4ee753965a8ad1.jpg",
            rating = null
        )
        reviews.add(
            Review(
                author = "garethmb",
                content = "In a magical land known as Kumandra; Humans and Dragons co-exist in harmony. When a threat in the form of creatures known as Druun arrive and threaten to destroy everything; the Dragons combine their power to defeat them but in doing so all but one of the Dragons remains.\\r\\n\\r\\nIn the new Disney animated film “Raya and the Last Dragon”; audiences are introduced to the narrative of the story by Raya (Kelly Marie Tran), who tells that the world has become fractured and she is to blame. A sacred relic that the Dragons used to Defeat the Druun has given her kingdom prosperity but the surrounding kingdoms all named after various parts of a Dragon are envious of their position.\\r\\n\\r\\nWhen Raya’s father Chief Benja (Daniel Dae Kim); attempts to unite the other kingdoms, a tragic betrayal results in the relic becoming fractured with each kingdom taking a fragment. As if this situation was not bad enough; the fracturing of the relic ushers in the return of the Druun and they quickly resume turning everything not protected by a barrier of water to stone.\\r\\n\\r\\nThe story then jumps years into the future where Raya and her faithful companion Tuk Tuk (Alan TudyK) are searching the rivers of the kingdoms in an effort to find the location where the last Dragon Sisu (Awkwafina) is rumored to have been sleeping for 500 years.\\r\\n\\r\\nRaya is eventually able to locate Sisu who is a very playful and animated creature and the two set off to save the day by obtaining the missing fragments through any means necessary. Naturally, their journey will be filled with dangers, adventure, and humor, as the various kingdoms have their own unique visual style and characters; some of whom join with Raya on her quest to provide much-needed support, perspective, and at times; humor.\\r\\n\\r\\nThe movie is visually amazing as the artists clearly were inspired to create a world that combines elements of many Asian cultures yet has its own unique traits. I marveled at the details of the water and ripples and how the railings on a boat showed uneven discoloration and wear in just a casual scene where the characters talked. It is this attention to detail that really adds to the magic of the film as well as the immersion into fantasy.\\r\\n\\r\\nThe supporting cast was great and there are some characters I do not wish to spoil who practically steals every scene in which they are in.  My wife and I were captivated from the very start as Disney has created a film that embodies much of their classic themes and yet expands upon them to create a film the entire family will enjoy.\\r\\n\\r\\nThe movie will be released in cinemas and via a paid option for Disney+ subscribers. We attended a press screening at a cinema; our first in almost a year and found the setup to be very safe and it was amazing to see such visual splendor on a big screen.\\r\\n\\r\\nDisney has once again created a new classic and has given audiences the magic that they are known for at a time when it is most needed.\\r\\n\\r\\n4 stars out of 5.",
                id = "603d201b33a533004bd1906e",
                authorDetail = authorDetail
            )
        )
        return reviews
    }
}