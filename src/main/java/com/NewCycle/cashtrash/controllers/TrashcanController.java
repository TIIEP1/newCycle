package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.dtos.request.RequestPostTrashcan;
import com.NewCycle.cashtrash.dtos.request.RequestPutTrashcan;
import com.NewCycle.cashtrash.dtos.response.ReponseGetTrashcanSimplific;
import com.NewCycle.cashtrash.model.Trashcan;
import com.NewCycle.cashtrash.services.TrashcanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trashcan")
public class TrashcanController {

    private final TrashcanService trashcanService;

    public TrashcanController(TrashcanService trashcanService) {
        this.trashcanService = trashcanService;
    }

    @GetMapping
    public ResponseEntity<List<ReponseGetTrashcanSimplific>> getAll(){
        return ResponseEntity.ok().body(trashcanService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReponseGetTrashcanSimplific> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(trashcanService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReponseGetTrashcanSimplific> insert(@RequestBody RequestPostTrashcan requestPostTrashcan){
        ReponseGetTrashcanSimplific obj = trashcanService.create(requestPostTrashcan);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.id()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trashcan> update(@PathVariable Long id ,@RequestBody RequestPutTrashcan requestPutTrashcan){
        Trashcan obj = trashcanService.update(id, requestPutTrashcan);
        return ResponseEntity.ok().body(trashcanService.update(id, requestPutTrashcan));
    }
}
