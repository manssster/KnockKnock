package knockknock.controller;

import knockknock.model.ErrorResp;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorsController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping()
    public ErrorResp error(HttpServletRequest request) {
        String uri = request.getRequestURL().toString();
        return new ErrorResp("No HTTP resource was found that matches the request URI '" + uri + "'.");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
