package by.intexsoft.demo.handler;

import by.intexsoft.demo.handler.action.IActionHandler;
import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.intexsoft.demo.model.Response.errorResponse;

@Component
public class MainHandler implements IMainHandler {
    private static final String ACTION_FIELD_NAME = "action";
    private final Map<String, IActionHandler> actionHandlers;

    public MainHandler(Map<String, IActionHandler> actionHandlers) {
        this.actionHandlers = actionHandlers;
    }

    @Override
    public Response handle(Payload payload) {
        Object actionField = payload.getField(ACTION_FIELD_NAME);
        if (actionField == null) {
            return errorResponse("Payload field: *" + ACTION_FIELD_NAME + "* is not specified");
        }
        IActionHandler actionHandler = actionHandlers.get("Action" + actionField);
        if (actionHandler == null) {
            return errorResponse("Payload field: *" + ACTION_FIELD_NAME + "* has illegal value");
        }
        return processAction(actionHandler, payload);
    }

    private Response processAction(IActionHandler actionHandler, Payload payload) {
        try {
            Object obj = "aa \" aa";
            System.out.println(obj);
            return actionHandler.handle(payload);
        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }
    }
}
