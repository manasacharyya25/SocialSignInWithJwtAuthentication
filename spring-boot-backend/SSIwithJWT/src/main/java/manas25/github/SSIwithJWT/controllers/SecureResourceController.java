package manas25.github.SSIwithJWT.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secureresource")
public class SecureResourceController
{
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getSecureResource() {
        return "You are accessing Secure Resource";
    }
}
