package com.okta.developer.matrixapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
// By default, the exporter exposes your CrudRepository by using the name of the domain class.
// Spring Data REST also applies the Evo Inflector to pluralize this word. Hence /notes
// https://docs.spring.io/spring-data/rest/docs/current/reference/html/#customizing-sdr.overriding-sdr-response-handlers.annotations
public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findAllIByUser(String user);

}
