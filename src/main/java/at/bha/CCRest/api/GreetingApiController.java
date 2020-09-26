package at.bha.CCRest.api;

import at.bha.CCRest.model.Greeting;
import at.bha.CCRest.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GreetingApiController {

    @Autowired
    private GreetingRepository repository;

    @GetMapping("/api/greeting")
    public Greeting greeting(@RequestParam(value = "id") Integer id) {
        Optional<Greeting> og = repository.findById(id);
        return og.get();
    }
}
