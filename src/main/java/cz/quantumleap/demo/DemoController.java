package cz.quantumleap.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    @PreAuthorize("permitAll()")
    public String index() {
        return "demo/entry";
    }
}
