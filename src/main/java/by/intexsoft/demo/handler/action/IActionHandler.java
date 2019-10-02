package by.intexsoft.demo.handler.action;

import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;

public interface IActionHandler {
    Response handle(Payload payload);
}
