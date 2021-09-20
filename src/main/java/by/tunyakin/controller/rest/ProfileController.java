package by.tunyakin.controller.rest;

import by.tunyakin.service.api.IUserService;
import by.tunyakin.service.dto.UserProfileDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final IUserService userService;
    private final ObjectMapper mapper;

    public ProfileController(IUserService userService, ObjectMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR')")
    public ResponseEntity<UserProfileDto> GetUserProfileById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(new UserProfileDto(userService.getUserById(id)), HttpStatus.OK);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
