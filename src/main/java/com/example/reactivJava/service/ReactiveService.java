package com.example.reactivJava.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public interface ReactiveService {
     List<Integer> getFirstChart();
      List<Integer> getSecondChart();
     List<Integer> getThirdChart();
     List<Integer> getFourthChart();
}
