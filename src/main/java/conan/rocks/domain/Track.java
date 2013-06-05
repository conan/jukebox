package conan.rocks.domain;

import com.yammer.dropwizard.json.JsonSnakeCase;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.nio.ByteBuffer;

@JsonSnakeCase
public class Track {

    public static final int MAX_TRACK_BYTES = 1024 * 1024 * 256;

    @JsonProperty
    private String trackId;

    @JsonProperty
    @NotEmpty
    private String title;

    @JsonProperty
    private String artist;

    @NotEmpty
    private ByteBuffer trackData;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ByteBuffer getTrackData() {
        return trackData;
    }

    public void setTrackData(ByteBuffer trackData) {
        this.trackData = trackData;
    }
}
