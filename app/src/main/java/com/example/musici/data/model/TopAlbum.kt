package com.example.musici.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep


data class TopAlbum(
    @SerializedName("albums")
    var albums: Albums?
) {

}

data class Albums(
    @SerializedName("album")
    var album: List<Album?>?,
    @SerializedName("@attr")
    var attr: Attri?
) {

}
@Keep
data class Attri(
    @SerializedName("page")
    var page: String?, // 1
    @SerializedName("perPage")
    var perPage: String?, // 50
    @SerializedName("tag")
    var tag: String?, // disco
    @SerializedName("total")
    var total: String?, // 4286
    @SerializedName("totalPages")
    var totalPages: String? // 86
)


data class Album(
    @SerializedName("artist")
    var artist: ArtistAlbum?,
    @SerializedName("@attr")
    var attr: Attribu?,
    @SerializedName("image")
    var image: List<ImageAlbum?>?,
    @SerializedName("mbid")
    var mbid: String?,
    @SerializedName("name")
    var name: String?, // Dynamite
    @SerializedName("url")
    var url: String? // https://www.last.fm/music/BTS
) {

}

@Keep
data class ArtistAlbum(
    @SerializedName("mbid")
    var mbid: String?, // 0d79fe8e-ba27-4859-bb8c-2f255f346853
    @SerializedName("name")
    var name: String?, // BTS
    @SerializedName("url")
    var url: String? // https://www.last.fm/music/BTS
)

@Keep
data class Attribu(
    @SerializedName("rank")
    var rank: String? // 1
)

@Keep
data class ImageAlbum(
    @SerializedName("size")
    var size: String?, // small
    @SerializedName("#text")
    var text: String? // https://lastfm.freetls.fastly.net/i/u/34s/41b15d8a0ad6a81323b598bfb19cede9.png
)



