package com.example.musici.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class TopArtists(
    @SerializedName("artists")
    var artists: Artists?
) {

}


data class Artists(
    @SerializedName("artist")
    var artist: List<TopArtist?>?,
    @SerializedName("@attr")
    var attr: ArtistAttr?
) {

}

@Keep
data class TopArtist(
    @SerializedName("image")
    var image: List<ArtistImage?>?,
    @SerializedName("listeners")
    var listeners: String?, // 2105082
    @SerializedName("mbid")
    var mbid: String?, // c8b03190-306c-4120-bb0b-6f2ebfc06ea9
    @SerializedName("name")
    var name: String?, // The Weeknd
    @SerializedName("playcount")
    var playcount: String?, // 191923156
    @SerializedName("streamable")
    var streamable: String?, // 0
    @SerializedName("url")
    var url: String? // https://www.last.fm/music/The+Weeknd
) {

}

@Keep
data class ArtistImage(
    @SerializedName("size")
    var size: String?, // small
    @SerializedName("#text")
    var text: String? // https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png
)


@Keep
data class ArtistAttr(
    @SerializedName("page")
    var page: String?, // 1
    @SerializedName("perPage")
    var perPage: String?, // 50
    @SerializedName("total")
    var total: String?, // 3982144
    @SerializedName("totalPages")
    var totalPages: String? // 79643
)
