package conan.rocks.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import conan.rocks.domain.Track;
import conan.rocks.mapper.TrackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TrackDao {

    @Autowired
    private Cluster cluster;

    @Autowired
    private Session session;

    @Autowired
    private TrackMapper mapper;

    public Track getTrack(String trackId) {
        PreparedStatement preparedStatement = session.prepare("SELECT * FROM Tracks WHERE id = ?");
        BoundStatement boundStatement = new BoundStatement(preparedStatement);
        boundStatement.bind(UUID.fromString(trackId));
        ResultSet resultSet = session.execute(boundStatement);
        Row row = resultSet.one();
        if(row == null) {
            return null;
        } else {
            return mapper.build(row);
        }
    }

    public void putTrack(Track track) {
        // TODO
    }
}
