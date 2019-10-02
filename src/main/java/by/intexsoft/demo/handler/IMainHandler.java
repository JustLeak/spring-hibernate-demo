package by.intexsoft.demo.handler;

import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;

public interface IMainHandler {
    Response handle(Payload payload);
}
