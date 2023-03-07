package com.example.reactivJava.service;

import com.example.reactivJava.model.TourPackage;

import com.example.reactivJava.repo.ReactiveTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
public class ReactiveDbService {
    @Autowired
    private ReactiveTestRepo reactiveTestRepo ;

    public ReactiveDbService(ReactiveTestRepo reactiveTestRepo) {
        this.reactiveTestRepo = reactiveTestRepo;
    }

    public List<TourPackage> getTours(){
        return reactiveTestRepo.findAll();
    }
    public void saveTour( String code , String name){

        TourPackage t =new TourPackage(code ,name);
        reactiveTestRepo.save(t);
        System.out.println("Save Done Service ");
    }
}
