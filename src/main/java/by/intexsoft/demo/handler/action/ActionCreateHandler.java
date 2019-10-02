package by.intexsoft.demo.handler.action;

import by.intexsoft.demo.handler.action.create.IObjectCreateHandler;
import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.intexsoft.demo.model.Response.errorResponse;

@Component("ActionCreate")
public class ActionCreateHandler implements IActionHandler{
    private static final String OBJ_FIELD_NAME = "obj";
    private final Map<String, IObjectCreateHandler> handlerMap;

    public ActionCreateHandler(Map<String, IObjectCreateHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public Response handle(Payload payload) {
        Object objField = payload.getField(OBJ_FIELD_NAME);
        if (objField == null) {
            return errorResponse("Payload field: \"" + OBJ_FIELD_NAME + "\" is not specified");
        }
        IObjectCreateHandler objectCreateHandler = handlerMap.get("CreateObj" + objField);
        if (objectCreateHandler == null) {
            return errorResponse("Payload field: \"" + OBJ_FIELD_NAME + "\" has illegal value");
        }
        return objectCreateHandler.handle(payload);
    }
}
