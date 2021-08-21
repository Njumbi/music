package com.example.musici.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep


data class TopTracks(
    @SerializedName("tracks")
    var tracks: Tracks?
)
{

}

data class Tracks(
    @SerializedName("@attr")
    var attr: Attr?,
    @SerializedName("track")
    var track: List<Track?>?
)
{

}

data class Attr(
    @SerializedName("page")
    var page: String?, // 1
    @SerializedName("perPage")
    var perPage: String?, // 50
    @SerializedName("total")
    var total: String?, // 28606092
    @SerializedName("totalPages")
    var totalPages: String? // 572122
)

data class Track(
    @SerializedName("artist")
    var artist: Artist?,
    @SerializedName("duration")
    var duration: String?, // 0
    @SerializedName("image")
    var image: List<Image?>?,
    @SerializedName("listeners")
    var listeners: String?, // 465687
    @SerializedName("mbid")
    var mbid: String?,
    @SerializedName("name")
    var name: String?, // good 4 u
    @SerializedName("playcount")
    var playcount: String?, // 9519488
    @SerializedName("streamable")
    var streamable: Streamable?,
    @SerializedName("url")
    var url: String? // https://www.last.fm/music/Olivia+Rodrigo/_/good+4+u
)
{

}

data class Artist(
    @SerializedName("mbid")
    var mbid: String?,
    @SerializedName("name")
    var name: String?, // Olivia Rodrigo
    @SerializedName("url")
    var url: String? // https://www.last.fm/music/Olivia+Rodrigo
)


data class Image(
    @SerializedName("size")
    var size: String?, // small
    @SerializedName("#text")
    var image: String? // https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png
)


data class Streamable(
    @SerializedName("fulltrack")
    var fulltrack: String?, // 0
    @SerializedName("#text")
    var text: String? // 0
)


