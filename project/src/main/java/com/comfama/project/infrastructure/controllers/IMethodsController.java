package com.comfama.project.infrastructure.controllers;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IMethodsController<T,U,I> {

    ResponseEntity<Iterable<T>> getAll();

    ResponseEntity<T> getOne(@PathVariable I i);

    ResponseEntity<T> create(@RequestBody U u);

    ResponseEntity<Void> delete(@PathVariable I i);



}
