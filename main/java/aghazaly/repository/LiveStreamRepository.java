package aghazaly.repository;

import aghazaly.exception.LiveStreamNotFoundException;
import aghazaly.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository(){
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "bulding rest api" ,
                "spring boot live streams",
                "https://www.youtube.com",
                LocalDateTime.of(2022,6 ,16 ,11,0),
                LocalDateTime.of(2022,9 ,16 ,11,0)
        ));
    }

    //find all mehtod
    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findByid(String id) throws LiveStreamNotFoundException {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElseThrow(LiveStreamNotFoundException::new);
    }



    //create
    public LiveStream create (LiveStream stream){
        streams.add(stream);
        return stream;}

    //update
    public void update(LiveStream stream , String id){
        LiveStream existing = streams.stream()
                .filter(s -> s.id().equals(id))
                .findFirst().orElseThrow(()-> new IllegalArgumentException("stream not found "));
        int i = streams.indexOf(existing);
        stream.set(i,stream);
    }
    public void delete(String id ){
        streams.removeIf(stream -> stream.id().equals(id));
    }

    }

