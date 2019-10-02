package by.intexsoft.demo.dao;

import by.intexsoft.demo.entity.Counter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CounterDAO implements ICounterDAO {
    private List<Counter> counterList = new ArrayList<>();

    @PostConstruct
    private void init() {
        counterList.add(new Counter());
    }

    @Override
    public Counter findCounter() {
        return counterList.get(0);
    }

    @Override
    public void update(Counter newCounter) {
        counterList.set(0, newCounter);
    }
}
