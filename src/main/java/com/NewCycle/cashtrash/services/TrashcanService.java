package com.NewCycle.cashtrash.services;

import com.NewCycle.cashtrash.dtos.request.RequestPostTrashcan;
import com.NewCycle.cashtrash.dtos.request.RequestPutTrashcan;
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

    private Trashcan findByIdCompleteTrashcan(Long id){
        Trashcan obj = trashcanRepository.findById(id).orElseThrow(() -> new TrashcanNotFoundException(id));
        return obj;
    }

    public ReponseGetTrashcanSimplific create(RequestPostTrashcan request){
        Trashcan obj = trashcanRepository.save(request.toTrashcan());
        return ReponseGetTrashcanSimplific.toReposeGetTrashcanSimplific(obj);
    }

    public Trashcan update(Long id, RequestPutTrashcan request){
        Trashcan oldTrashcan = findByIdCompleteTrashcan(id);
        if(request.getName() != null){
            oldTrashcan.setName(request.getName());
        }
        if (request.getActive() != null){
            oldTrashcan.setActive(request.getActive());
        }
        if (request.getFully() != null){
            oldTrashcan.setFully(request.getFully());
        }

        if (request.getCapacidade() != null){
            oldTrashcan.setCapacidade(request.getCapacidade());
        }

        return trashcanRepository.save(oldTrashcan);
    }
}
