package by.intexsoft.demo.service;

import by.intexsoft.demo.dao.ICounterDAO;
import by.intexsoft.demo.entity.Counter;
import org.springframework.stereotype.Service;

@Service
public class CounterService implements ICounterService {
    private final ICounterDAO counterDAO;

    public CounterService(ICounterDAO counterDAO) {
        this.counterDAO = counterDAO;
    }

    @Override
    public void incCounter() {
        Counter counter = counterDAO.findCounter();
        counter.inc();
        counterDAO.update(counter);
    }

    @Override
    public Counter findCounter() {
        return counterDAO.findCounter();
    }
}
