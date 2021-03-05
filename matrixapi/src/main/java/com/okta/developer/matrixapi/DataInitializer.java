package com.okta.developer.matrixapi;

import com.okta.developer.repo.Note;
import com.okta.developer.repo.NoteRepository;
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
        noteList.add(new Note("note1"));
        noteList.add(new Note("note2"));
        noteList.add(new Note("note3"));

       for (Note note :noteList){

           noteRepository.save(note);
       }
        noteRepository.findAll();
    }
}
