package by.intexsoft.demo.handler.action;

import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import by.intexsoft.demo.handler.action.get.IObjectGetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.intexsoft.demo.model.Response.errorResponse;

@Component("ActionGET")
public class ActionGetHandler implements IActionHandler {
    private static final String OBJ_FIELD_NAME = "obj";
    @Autowired
    private Map<String, IObjectGetHandler> handlerMap;

    public Response handle(Payload payload) {
        Object objField = payload.getField(OBJ_FIELD_NAME);

        if (objField == null) {
            return errorResponse("Payload field: \"" + OBJ_FIELD_NAME + "\" is not specified");
        }

        IObjectGetHandler getObjectHandler = handlerMap.get("Obj" + objField);
        if (getObjectHandler == null) {
            return errorResponse("Payload field: \"" + OBJ_FIELD_NAME + "\" has illegal value");
        }

        return getObjectHandler.handle(payload);
    }
}
