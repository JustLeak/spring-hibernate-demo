package by.intexsoft.demo.controller;

import by.intexsoft.demo.handler.IMainHandler;
import by.intexsoft.demo.model.Payload;
import by.intexsoft.demo.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/counter")
public class MainController {
    private final IMainHandler mainHandler;

    public MainController(IMainHandler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<Response> counter(@RequestBody Payload payload) {
        return ResponseEntity.ok(mainHandler.handle(payload));
    }
}
