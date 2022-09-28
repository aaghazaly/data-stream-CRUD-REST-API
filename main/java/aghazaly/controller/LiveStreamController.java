package aghazaly.controller;

import aghazaly.exception.LiveStreamNotFoundException;
import aghazaly.model.LiveStream;
import aghazaly.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stream")
public class LiveStreamController<retrun> {

    private final LiveStreamRepository repository;
    @Autowired
    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }
  //find all
    @GetMapping
    public List<LiveStream> findall(){
        return  repository.findAll() ;
    }

    //find by id
     @GetMapping("/{id}")
    public LiveStream findbyid(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findByid(id);
     }

    //create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create ( @Valid @RequestBody LiveStream stream){
        return repository.create(stream);
    }

    //update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody LiveStream stream , @PathVariable String id){
         repository.update(stream,id);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    public void delete(@PathVariable String id) {
        repository.delete(id);
    }


}
