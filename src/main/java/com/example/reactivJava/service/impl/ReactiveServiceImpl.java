package com.example.reactivJava.service.impl;

import com.example.reactivJava.service.ReactiveService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReactiveServiceImpl implements ReactiveService {

    @Override
    public List<Integer> getFirstChart() {
        List<Integer> chartOne = new ArrayList<>();
        chartOne.add(1);
        chartOne.add(2);
        chartOne.add(3);
        chartOne.add(4);
        chartOne.add(5);
        return  chartOne;
    }

    @Override
    public List<Integer> getSecondChart() {
        List<Integer> chartTwo = new ArrayList<>();
        chartTwo.add(6);
        chartTwo.add(7);
        chartTwo.add(8);
        chartTwo.add(9);
        chartTwo.add(10);
        return  chartTwo;
    }

    @Override
    public List<Integer> getThirdChart() {
        List<Integer> chartThree = new ArrayList<>();
        chartThree.add(11);
        chartThree.add(12);
        chartThree.add(13);
        chartThree.add(14);
        chartThree.add(15);
        return chartThree;
    }

    @Override
    public List<Integer> getFourthChart() {
        List<Integer> chartFour = new ArrayList<>();
        chartFour.add(16);
        chartFour.add(17);
        chartFour.add(18);
        chartFour.add(19);
        chartFour.add(20);
        return  chartFour;
    }

    public Flux<Integer> getFirstChartFlux() {
        List<Integer> chartOne = new ArrayList<>();
        chartOne.add(1);
        chartOne.add(2);
        chartOne.add(3);
        chartOne.add(4);
        chartOne.add(5);
        return  Flux.fromStream(chartOne.stream());
    }
    public Flux<Integer> getSecondChartFlux() {
        List<Integer> chartTwo = new ArrayList<>();
        chartTwo.add(6);
        chartTwo.add(7);
        chartTwo.add(8);
        chartTwo.add(9);
        chartTwo.add(10);
        return Flux.fromStream(chartTwo.stream());
    }
}
