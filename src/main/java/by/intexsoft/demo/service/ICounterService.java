package by.intexsoft.demo.service;

import by.intexsoft.demo.entity.Counter;

public interface ICounterService {
    void incCounter();

    Counter findCounter();
}
