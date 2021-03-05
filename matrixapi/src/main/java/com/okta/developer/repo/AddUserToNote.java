package com.okta.developer.repo;


import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler({Note.class})
public class AddUserToNote {

    @HandleBeforeCreate
    void handleCreate( Note note){
      String name =  SecurityContextHolder.getContext().getAuthentication().getName();
      System.out.println("Creating Note :: " +note + "with username " + name);
      note.setUser(name);
    }
}
