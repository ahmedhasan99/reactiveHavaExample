package com.example.reactivJava.controller;

import com.example.reactivJava.model.TourPackage;
import com.example.reactivJava.service.ReactiveDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping
public class ReactiveController {
    @Autowired
    private ReactiveDbService reactiveDbService;

    public ReactiveController(ReactiveDbService reactiveDbService) {
        this.reactiveDbService = reactiveDbService;
    }
//    @PostMapping("add")
//    public void saveTour(){
//        TourPackage t =new TourPackage("01" ,"Ahmed");
//        reactiveDbService.saveTour(t.getCode() ,t.getName());
//        System.out.println("Save Done Controller ");
//    }
    @GetMapping("one")
    public List<TourPackage> getTours(){
        return reactiveDbService.getTours();
    }
}
