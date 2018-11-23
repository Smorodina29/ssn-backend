package ssn.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssn.commons.api.response.ApiResponse;
import ssn.facades.exeptions.AuthenticationFailedException;
import ssn.facades.exeptions.EntityNotFoundException;
import ssn.facades.model.UserFacade;
import ssn.facades.services.UserService;
import ssn.web.contracts.UserLoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserControllers {

    @Autowired
    private UserService userService;

    @Value("${ru.ddg.stalt.security.token.header}")
    private String authTokenHeaderKey;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse login(@RequestBody @Validated final UserLoginDto loginDto, HttpServletResponse response,
                             HttpServletRequest request) throws AuthenticationFailedException, EntityNotFoundException {

        UserFacade user = userService.login(loginDto.getLogin(), loginDto.getPassword());
    }
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
