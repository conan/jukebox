package conan.rocks.mapper;

import com.datastax.driver.core.Row;
import conan.rocks.domain.Track;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TrackMapper {

    public Track build(Row row) {
        Track track = new Track();
        track.setTrackId(row.getString("id"));
        track.setTrackData(row.getBytes("data"));
        return track;
    }
}
