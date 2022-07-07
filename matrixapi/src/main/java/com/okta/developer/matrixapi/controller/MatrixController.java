package com.okta.developer.matrixapi.controller;

import com.okta.developer.matrixapi.repo.NoteRepository;
import com.okta.developer.matrixapi.repo.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MatrixController {
    @Autowired
    NoteRepository noteRepository;


   @GetMapping("user/notes")
    public List<Note> getUserNotes(Principal principal){
        String userEmail = ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("email");
        List<Note> notes = noteRepository.findAllIByUser(userEmail);
        return  notes;
    }

    @GetMapping("/user")
    public OidcUser getUser(@AuthenticationPrincipal OidcUser oidcUser){

        return oidcUser;
    }



}
