package by.intexsoft.demo.dao;

import by.intexsoft.demo.entity.Counter;

public interface ICounterDAO {
    Counter findCounter();

    void update(Counter newCounter);
}
