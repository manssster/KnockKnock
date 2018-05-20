package knockknock.controller;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import knockknock.impl.KnockKnockImpl;
import knockknock.model.TriangleTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    private final AtomicLong counter = new AtomicLong();
    private KnockKnockImpl impl = new KnockKnockImpl();

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("originalUrl", req.getRequestURL());
        req.getRequestDispatcher("/error").forward(req, resp);
    }

    @GetMapping("/api/Token")
    @ResponseBody
    public UUID Token() {
        return impl.getToken();
    }

    @GetMapping("/api/Fibonacci")
    @ResponseBody
    public ResponseEntity Fibonacci(@RequestParam(value="n")long sequence) {
        return impl.getFibonacciSequence(sequence);
    }

    @GetMapping("/api/ReverseWords")
    @ResponseBody
    public String ReverseWords(@RequestParam(value="sentence", required = false) String sentence) {
        return impl.reverseWords(sentence);
    }

    @GetMapping("/api/TriangleType")
    @ResponseBody
    public TriangleTypes TriangleType(@RequestParam()int a, int b, int c) {
        return impl.triangleType(a, b, c);
    }
}
