package conan.rocks.api;

import com.yammer.metrics.annotation.Timed;
import conan.rocks.domain.Track;
import conan.rocks.domain.TrackMeta;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.ByteBuffer;
import java.util.UUID;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tracks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class TrackAcceptor {

    @Autowired
    private conan.rocks.dao.TrackDao trackDao;


    @POST
    @Timed
    public TrackMeta add(@Valid ByteBuffer trackData) {
        Track track = new Track();
        track.setTrackId(UUID.randomUUID().toString());
        track.setTrackData(trackData);
        trackDao.putTrack(track);

        TrackMeta meta = new TrackMeta();
        meta.setTrackId(track.getTrackId());
        return meta;
    }

}
