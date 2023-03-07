package com.example.reactivJava.controller;

import com.example.reactivJava.model.TourPackage;
import com.example.reactivJava.service.ReactiveDbService;
import com.example.reactivJava.service.ReactiveService;
import com.example.reactivJava.service.impl.ReactiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;



@RestController
@RequestMapping
public class controller {
    @Autowired
    private ReactiveService reactiveService;
    @Autowired
    private ReactiveDbService reactiveDbService;
    @Autowired
    private ReactiveServiceImpl fluxReactiveService;
    @GetMapping( value = "getAll", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
    public ParallelFlux<String> getFlux() {

        List<Integer> one = reactiveService.getFirstChart();
        List<Integer> two = reactiveService.getSecondChart();
        List<Integer> three = reactiveService.getThirdChart();
        List<Integer> four = reactiveService.getFourthChart();
        List<TourPackage> tourPackages = reactiveDbService.getTours();
        ParallelFlux<String> parallelflux= Flux.just(Pair.of("Test" , tourPackages),Pair.of("One",one) ,Pair.of("two",two) , Pair.of("three",three) ,Pair.of("four",four))
                .delayElements(Duration.ofSeconds(2))
                .map(a -> "{\""+a.getFirst()+ "\":" +a.getSecond() +"}\n")
                .log()
                .parallel();
        return parallelflux.runOn(Schedulers.parallel());
    }

    @GetMapping( value = "re", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
    public Flux<Integer> testo() {
        return Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping( value = "getAllFlux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
    public ParallelFlux<String> getFluxFromService() {

        Flux<Integer> oneFlux =fluxReactiveService.getFirstChartFlux();
        Flux<Integer> twoFlux = fluxReactiveService.getSecondChartFlux();
        Flux<Integer> three = fluxReactiveService.getSecondChartFlux();
        ParallelFlux<String> parallelflux = Flux.zip(oneFlux, twoFlux, three)
                .delayElements(Duration.ofSeconds(2))
                .parallel()
                .map(a -> a + "")
                .log();

       return parallelflux.runOn(Schedulers.parallel());

    }


}

