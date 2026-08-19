package com.NewCycle.cashtrash.services;

import com.NewCycle.cashtrash.dtos.request.RequestPostTrashcan;
import com.NewCycle.cashtrash.dtos.response.ReponseGetTrashcanSimplific;
import com.NewCycle.cashtrash.model.Trashcan;
import com.NewCycle.cashtrash.model.exception.TrashcanNotFoundException;
import com.NewCycle.cashtrash.repositories.TrashcanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrashcanService {

    public final TrashcanRepository trashcanRepository;

    public TrashcanService(TrashcanRepository trashcanRepository) {
        this.trashcanRepository = trashcanRepository;
    }

    public List<ReponseGetTrashcanSimplific> getAll(){
        return trashcanRepository.findAll()
                .stream()
                .map(ReponseGetTrashcanSimplific::toReposeGetTrashcanSimplific).toList();
    }

    public ReponseGetTrashcanSimplific findById(Long id){
       Trashcan obj = trashcanRepository.findById(id).orElseThrow(() -> new TrashcanNotFoundException(id));
       return ReponseGetTrashcanSimplific.toReposeGetTrashcanSimplific(obj);
    }

    public ReponseGetTrashcanSimplific create(RequestPostTrashcan request){

        return null;
    }
}
