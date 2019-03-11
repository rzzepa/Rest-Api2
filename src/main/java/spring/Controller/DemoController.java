package spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {


    @GetMapping("/leaders")
    public String showLeaders() {

        return "leaders.jsp";
    }

    @GetMapping("/admins")
    public String showAdmin() {

        return "admins.jsp";
    }

    @GetMapping("/")
    public String home(Model model) {


        return "home.jsp";


    }

    @GetMapping("/customer-service")
    public String test(Model model) {


        return "customer-service.jsp";


    }
}
