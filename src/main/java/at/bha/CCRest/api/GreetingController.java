package at.bha.CCRest.api;

import at.bha.CCRest.model.Greeting;
import at.bha.CCRest.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Controller //Annotation
public class GreetingController {

   /* They are format specifiers used in some methods like printf() to format the string.
    The %s is replaced with the times value (below in the example).
    The %n tells the console print it in a new line.
*/
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;



    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {

        greetingRepository.save(greeting);
        model.addAttribute("greeting",greeting);
        return "result";
    }

    // test?id=1
    @GetMapping("/test")
    public Greeting testGreeting(@RequestParam(value = "id") Integer id) {
        Optional<Greeting> g = greetingRepository.findById(id);
        return g.get();
    }

    @PostMapping("/add")
    public String addGreeting(String content, String test) {

        return "added";
    }
}
