package com.NewCycle.cashtrash.dtos.response;

import com.NewCycle.cashtrash.model.Address;
import com.NewCycle.cashtrash.model.Trashcan;

public record ReponseGetTrashcanSimplific(String id, String name, String fully, Address address ) {

    public static ReponseGetTrashcanSimplific toReposeGetTrashcanSimplific(Trashcan trashcan){

        Address address = trashcan.getAddress();


        return new ReponseGetTrashcanSimplific(trashcan.getId().toString()
                ,trashcan.getName()
                ,trashcan.getFully().toString(), trashcan.getAddress());
    }
}
