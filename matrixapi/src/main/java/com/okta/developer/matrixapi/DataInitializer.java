package com.okta.developer.matrixapi;

import com.okta.developer.matrixapi.repo.Note;
import com.okta.developer.matrixapi.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RepositoryEventHandler(Note.class)
class DataInitialize  implements ApplicationRunner {


    private NoteRepository noteRepository;

    @Autowired
    public DataInitialize(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Note> noteList = new ArrayList<Note>();
        noteList.add(new Note("Buy Food"));
        noteList.add(new Note("Go to Groceries"));
        noteList.add(new Note("Pay Bill"));

        noteList.add(new Note(null, "Learning task" ,"Complete Mandatory learning modules", "jijilki@gmail.com"));

       for (Note note :noteList){

           noteRepository.save(note);
       }
        noteRepository.findAll();
    }
}
