package com.okta.developer.matrixapi.controller;

import com.okta.developer.matrixapi.repo.NoteRepository;
import com.okta.developer.matrixapi.repo.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
        System.out.println("Retrieving user notes for user ::: " + principal.getName());
        List<Note> notes = noteRepository.findAllIByUser(principal.getName());
        return  notes;
    }

    @GetMapping("/user")
    public OidcUser getUser(@AuthenticationPrincipal OidcUser oidcUser){

        return oidcUser;
    }

}
