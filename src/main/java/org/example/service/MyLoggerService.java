package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.MyLogger;
import org.example.repository.LoggerRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyLoggerService {
    private final LoggerRepository repository;

    public MyLogger saveLog(MyLogger log){
        return repository.save(log);

    }

}
