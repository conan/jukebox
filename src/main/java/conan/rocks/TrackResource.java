package conan.rocks;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import conan.rocks.domain.Track;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Path("/tracks")
@Produces(MediaType.APPLICATION_JSON)
public class TrackResource {

    private final AtomicLong counter;

    public TrackResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Track getTrack(@QueryParam("trackId") Optional<String> trackId) {
        Track track = new Track();
        track.setTrackId(UUID.randomUUID().toString());
        track.setTitle("Planetary Funk Alert");
        track.setArtist("Seba");
        track.setAlbum("Looking Back");
        return track;
    }

}
