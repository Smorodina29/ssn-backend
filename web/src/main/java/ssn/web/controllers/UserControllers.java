package ssn.web.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllers {
/*
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public APIResponse getUsers(){
               return ApiResponceFactory.success(userService.findAllUsers());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public APIResponse getUserByDI(@PathVariable Long id){
        return  ApiResponceFactory.success(userService.getUserById(id));
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public APIResponse registrUser(@RequestBody UserDto userDto){
        return  ApiResponceFactory.success(userService.registration(userDto));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public APIResponse delete(@PathVariable Long id){
        return ApiResponceFactory.success(userService.delete(id));
    }*/
    /*@RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getUserDtos(Model model){
        //model.addAttribute("users", userRepositories.findAll());
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public */
}
