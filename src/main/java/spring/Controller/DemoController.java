package spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home.jsp";
	}

    @GetMapping("/leaders")
    public String showLeaders() {

        return "leaders.jsp";
    }

    @GetMapping("/admins")
    public String showAdmin() {

        return "admins.jsp";
    }
}
