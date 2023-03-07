package com.example.reactivJava.repo;

import com.example.reactivJava.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReactiveTestRepo extends JpaRepository<TourPackage,String> {
//        Flux<TourPackage> findAllFlux();

}
