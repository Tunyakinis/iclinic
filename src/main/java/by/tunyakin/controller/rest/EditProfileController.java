package by.tunyakin.controller.rest;

import by.tunyakin.model.User;
import by.tunyakin.service.api.IUserService;
import by.tunyakin.service.dto.AddressDto;
import by.tunyakin.service.dto.PassportDto;
import by.tunyakin.service.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editProfile")
public class EditProfileController {
    private IUserService userService;

    public EditProfileController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PATIENT')")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(new UserDto(userService.getUserById(id)), HttpStatus.OK);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PATIENT')")
    protected ResponseEntity<?> updatePatient(@RequestBody User user, @PathVariable("id") Integer id) {
        userService.updateUser(user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/address/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR', 'PATIENT')")
    public ResponseEntity<Object> createAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id) {
        try{
            return new ResponseEntity<>(new AddressDto(userService.createAddress(userService.getUserById(id),
                    addressDto)), HttpStatus.OK);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR', 'PATIENT')")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(new AddressDto(userService.getUserById(id).getAddress()), HttpStatus.OK);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/address/{id}")
    @PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR', 'PATIENT')")
    public ResponseEntity<Object> updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(new AddressDto(userService.updateAddress(userService.getUserById(id),
                    addressDto)), HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/passport/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR', 'PATIENT')")
    public ResponseEntity<Object> createPassport(@RequestBody PassportDto passportDto, @PathVariable Integer id){
        try{
            return new ResponseEntity<>(new PassportDto(userService.createPassport(userService.getUserById(id),
                    passportDto)), HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "passport/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR', 'PATIENT')")
    public ResponseEntity<PassportDto> getPassportById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(new PassportDto(userService.getUserById(id).getPassport()), HttpStatus.OK);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/passport/{id}")
    @PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR', 'PATIENT')")
    public ResponseEntity<Object> updatePassportByUserId(@RequestBody PassportDto passportDto, @PathVariable Integer id){
        try{
            return new ResponseEntity<>(new PassportDto(userService.updatePassport(userService.getUserById(id),
                    passportDto)), HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
