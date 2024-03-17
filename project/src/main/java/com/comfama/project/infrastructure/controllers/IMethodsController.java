package com.comfama.project.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMethodsController<T,U,I> {

    ResponseEntity<Iterable<?>> getAll();

    ResponseEntity<?> getOne(@PathVariable I i);

    ResponseEntity<?> create(@RequestBody U u);

    ResponseEntity<?> update(@PathVariable I i, @RequestBody U u);

    ResponseEntity<Void> delete(@PathVariable I i);



}
