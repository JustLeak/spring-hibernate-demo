package by.intexsoft.demo.handler.action.get;

import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import by.intexsoft.demo.model.ServiceResponse;
import by.intexsoft.demo.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.intexsoft.demo.model.Response.errorResponse;
import static by.intexsoft.demo.model.Response.successResponse;

@Component("GetObjUser")
public class UserObjectGetHandler implements IObjectGetHandler {
    private static final String ID_FIELD_VALUE = "id";
    private static final String BODY_FIELD_VALUE = "body";
    private final IUserService userService;

    public UserObjectGetHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Response handle(Payload payload) {
        Object objBody = payload.getField(BODY_FIELD_VALUE);
        if (objBody == null) {
            return errorResponse("Payload field: *" + BODY_FIELD_VALUE + "* is not specified");
        }
        Map body;
        try {
            body = (Map) objBody;
        } catch (ClassCastException e) {
            return errorResponse("Payload field: *" + BODY_FIELD_VALUE + "* has illegal value");
        }
        Object idField = body.get(ID_FIELD_VALUE);
        long id;
        if (idField == null) {
            return errorResponse("Payload field: *" + BODY_FIELD_VALUE + "." + ID_FIELD_VALUE + "* is not specified");
        }
        try {
            id = (int) idField;
        } catch (ClassCastException e) {
            return errorResponse("Payload field: *" + BODY_FIELD_VALUE + "." + ID_FIELD_VALUE + "* has illegal value");
        }
        ServiceResponse response = userService.find(id);
        return response.isSuccess() ? successResponse(response.getResponseData())
                : errorResponse(response.getResponseData());
    }
}
