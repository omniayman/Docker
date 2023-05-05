package gov.iti.jets.controller;


import gov.iti.jets.UserService;
import gov.iti.jets.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    UserService userService = new UserService();

    @GetMapping("/")
    public Map<String, String> hello() {
        return Map.of("msg", "Hello");
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("you have an error");
            return "registerForm";
        }

        List<User> users = UserService.getUsers();
        for (User u : users) {
            System.out.println(u);
        }
        userService.addUser(user);
        return "helloWorldPage";
    }
    @RequestMapping(value = "/fileupload", method = RequestMethod.GET)
    public String upload(Model model) {
        model.addAttribute(new User());
        return "form2";

    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(@RequestParam("name") String name,
                                    @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {

            return "You successfully uploaded file=" + file.getOriginalFilename();
        } else {
            return "You failed to upload " + file.getOriginalFilename()
                    + " because the file was empty.";
        }
    }
}
