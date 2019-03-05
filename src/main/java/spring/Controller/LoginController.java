package spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		return "fancy-login.jsp";
	}

    @GetMapping("/access-denied")
    public String showAcessDenied() {

        return "access-denied.jsp";
    }
}
