package conan.rocks;

import com.yammer.metrics.annotation.Timed;
import conan.rocks.domain.TrackMeta;

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

    @POST
    @Timed
    public TrackMeta add(@Valid byte[] trackData) {
        //TODO persist file data
        return null;
    }

}
