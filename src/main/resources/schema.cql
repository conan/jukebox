CREATE KEYSPACE jukebox
    WITH REPLICATION = {'class' : 'NetworkTopologyStrategy', 'dc1' : 1}
    AND durable_writes = true;

USE jukebox;

CREATE TABLE jukebox.tracks (
     track_id UUID PRIMARY KEY
);