package gr.opensourceuom.presentation.hello;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/param")
    public String sayHelloWithRequestParam(@RequestParam String name) {
        return "Hello " + name;
    }
}
