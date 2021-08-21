package com.example.musici.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class SearchAlbums(
    @SerializedName("results")
    var results: SearchAlbumResults?
) {

}

@Keep
data class SearchAlbumResults(
    @SerializedName("@attr")
    var attr: SearchAlbumAttr?,
    @SerializedName("opensearch:itemsPerPage")
    var opensearchItemsPerPage: String?, // 30
    @SerializedName("opensearch:Query")
    var opensearchQuery: OpensearchQueryAlbum?,
    @SerializedName("opensearch:startIndex")
    var opensearchStartIndex: String?, // 0
    @SerializedName("opensearch:totalResults")
    var opensearchTotalResults: String?, // 731240
    @SerializedName("trackmatches")
    var trackmatches: TrackmatchesAlbum?
) {

}

@Keep
class SearchAlbumAttr(
)

@Keep
data class OpensearchQueryAlbum(
    @SerializedName("role")
    var role: String?, // request
    @SerializedName("startPage")
    var startPage: String?, // 1
    @SerializedName("#text")
    var text: String?
)

@Keep
data class TrackmatchesAlbum(
    @SerializedName("track")
    var track: List<SearchAlbum?>?
)
{

}

@Keep
data class SearchAlbum(
    @SerializedName("artist")
    var artist: String?, // Imagine Dragons
    @SerializedName("image")
    var image: List<ImageSearchAlbum?>?,
    @SerializedName("listeners")
    var listeners: String?, // 484367
    @SerializedName("mbid")
    var mbid: String?,
    @SerializedName("name")
    var name: String?, // Believer
    @SerializedName("streamable")
    var streamable: String?, // FIXME
    @SerializedName("url")
    var url: String? // https://www.last.fm/music/Imagine+Dragons/_/Believer
)
{

}
@Keep
data class ImageSearchAlbum(
    @SerializedName("size")
    var size: String?, // small
    @SerializedName("#text")
    var text: String? // https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png
)

