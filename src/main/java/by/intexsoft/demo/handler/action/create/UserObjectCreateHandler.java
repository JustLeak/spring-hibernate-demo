package by.intexsoft.demo.handler.action.create;

import by.intexsoft.demo.entity.User;
import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import by.intexsoft.demo.model.ServiceResponse;
import by.intexsoft.demo.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.intexsoft.demo.model.Response.errorResponse;
import static by.intexsoft.demo.model.Response.successResponse;

@Component("CreateObjUser")
public class UserObjectCreateHandler implements IObjectCreateHandler {
    public static final String NAME_FIELD = "name";
    public static final String SURNAME_FIELD = "surname";
    private static final String BODY_FIELD = "body";
    private final IUserService userService;

    public UserObjectCreateHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Response handle(Payload payload) {
        Object objBody = payload.getField(BODY_FIELD);
        Object nameField;
        Object surnameField;
        if (objBody == null) {
            return errorResponse("Payload field: *" + BODY_FIELD + "* is not specified");
        }
        Map body;
        try {
            body = (Map) objBody;
        } catch (ClassCastException e) {
            return errorResponse("Payload field: *" + BODY_FIELD + "* has illegal value");
        }
        nameField = body.get(NAME_FIELD);
        if (nameField == null) {
            return errorResponse("Payload field: *" + BODY_FIELD + "." + NAME_FIELD + "* is not specified");
        }
        surnameField = body.get(SURNAME_FIELD);
        if (surnameField == null) {
            return errorResponse("Payload field: *" + BODY_FIELD + "." + SURNAME_FIELD + "* is not specified");
        }
        if (!(nameField instanceof String)) {
            return errorResponse("Payload field: *" + BODY_FIELD + "." + NAME_FIELD + "* has illegal value");
        }
        if (!(surnameField instanceof String)) {
            return errorResponse("Payload field: *" + BODY_FIELD + "." + SURNAME_FIELD + "* has illegal value");
        }
        ServiceResponse response = userService.create(new User((String) nameField, (String) surnameField));
        return response.isSuccess() ? successResponse(response.getResponseData())
                : errorResponse(response.getResponseData());
    }
}
