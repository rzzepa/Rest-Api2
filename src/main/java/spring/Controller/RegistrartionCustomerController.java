package spring.Controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.crm.CrmEmployee;
import spring.crm.CrmUser;
import spring.entity.User;
import spring.service.UserService;


@Controller
    public class RegistrartionCustomerController {

    @Autowired
    private UserService userService;


    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("crmUser", new CrmUser());

        return "registerCustomer.jsp";
    }

    @GetMapping("/registerEmployee")
    public String showMyLoginPageEmployee(Model theModel) {

        theModel.addAttribute("crmEmployee", new CrmEmployee());

        return "registerEmployee.jsp";
    }



    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = theCrmUser.getUserName();
        logger.info("Processing registration form for: " + userName);

        // form validation
        if (theBindingResult.hasErrors()) {
            return "registerCustomer.jsp";
        }

        // check the database if user already exists
        User existing =userService.findByUserName(userName);
        if (existing != null) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name already exists.");

            logger.warning("User name already exists.");
            return "registerCustomer.jsp";
        }
        // create user account

        userService.save(theCrmUser);

        //logger.info("Successfully created user: " + userName);

        return "succes-register.jsp";
    }

    @PostMapping("/processRegistrationFormEmployee")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmEmployee") CrmEmployee crmEmployee,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = crmEmployee.getUserName();
        logger.info("Processing registration form for: " + userName);

        // form validation
        if (theBindingResult.hasErrors()) {
            return "registerEmployee.jsp";
        }

        // check the database if user already exists
        User existing =userService.findByUserName(userName);
        if (existing != null) {
            theModel.addAttribute("crmEmployee", new CrmEmployee());
            theModel.addAttribute("registrationError", "User name already exists.");

            logger.warning("User name already exists.");
            return "registerEmployee.jsp";
        }
        // create user account

        userService.save(crmEmployee);

        //logger.info("Successfully created user: " + userName);

        return "home.jsp";
    }
}