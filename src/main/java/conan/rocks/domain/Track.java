package conan.rocks.domain;

import java.nio.ByteBuffer;

public class Track {

    private String trackId;
    private ByteBuffer trackData;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public ByteBuffer getTrackData() {
        return trackData;
    }

    public void setTrackData(ByteBuffer trackData) {
        this.trackData = trackData;
    }
}
