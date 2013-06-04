package conan.rocks.api;

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

@Path("/tracks/{trackId}")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class TrackResource {

    @GET
    @Timed
    public Response getTrack(@PathParam("trackId") String trackId) throws URISyntaxException, IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("test.mp3");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (in.available() > 0) {
            out.write(in.read());
        }

        return Response.ok(out.toByteArray()).header("Content-Disposition", "attachment; filename=" + trackId + ".mp3").build();
    }

}
