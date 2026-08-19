package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.dtos.request.RequestPostTrashcan;
import com.NewCycle.cashtrash.dtos.response.ReponseGetTrashcanSimplific;
import com.NewCycle.cashtrash.services.TrashcanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ReponseGetTrashcanSimplific> insert(@RequestBody RequestPostTrashcan requestPostTrashcan){
        return null;
    }
}
