package knockknock.controller;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import knockknock.impl.KnockKnockImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final AtomicLong counter = new AtomicLong();
    private KnockKnockImpl impl = new KnockKnockImpl();

    @GetMapping("/api/Token")
    @ResponseBody
    public UUID Token() {
        return impl.getToken();
    }

    @GetMapping("/api/Fibonacci")
    @ResponseBody
    public long Fibonacci(@RequestParam(value="n")long sequence) {
        return impl.getFibonacciSequence(sequence);
    }

    @GetMapping("/api/ReverseWords")
    @ResponseBody
    public String ReverseWords(@RequestParam(value="sentence", required = false) String sentence) {
        return impl.reverseWords(sentence);
    }

    @GetMapping("/api/TriangleType")
    @ResponseBody
    public String TriangleType(@RequestParam()int a, int b, int c) {
        return impl.triangleType(a, b, c);
    }
}
