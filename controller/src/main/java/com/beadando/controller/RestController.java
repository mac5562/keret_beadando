package com.beadando.controller;


import com.beadando.exceptions.BdAddedBefore;
import com.beadando.exceptions.BdNotFound;
import com.beadando.exceptions.NameEmpty;
import com.beadando.model.Bd;
import com.beadando.service.BdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest/")
public class RestController {

    @Autowired
    BdService service;

    @GetMapping(value = "bds")
    public Collection<Bd> getAllBd(){
        return service.getEveryBd();
    }
    @GetMapping(value = "bd/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Bd getBdById(@PathVariable(name="id")String id) throws BdNotFound {
        return service.getBdById(id);
    }
    @PostMapping(value = "bd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addDolgozo(@RequestBody Bd bd) throws BdAddedBefore, NameEmpty {
        System.out.println("Hozzáadandó: "+bd);
        service.addBd(bd);
        return "Új kiadvány került hozzáadásra a következő azonosítóval: "+bd.getId();
    }

    @ExceptionHandler(BdAddedBefore.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String usedBdId(BdAddedBefore e){
        return "Kiadvány az adott azonositoval már létezik: "+e.getMessage();
    }


}
