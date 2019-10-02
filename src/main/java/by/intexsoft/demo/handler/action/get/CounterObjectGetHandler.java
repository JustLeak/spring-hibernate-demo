package by.intexsoft.demo.handler.action.get;

import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import by.intexsoft.demo.service.ICounterService;
import org.springframework.stereotype.Component;

@Component("ObjCounter")
public class CounterObjectGetHandler implements IObjectGetHandler {
    private final ICounterService counterService;

    public CounterObjectGetHandler(ICounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public Response handle(Payload payload) {
        counterService.incCounter();
        return Response.successResponse(counterService.findCounter());
    }
}
