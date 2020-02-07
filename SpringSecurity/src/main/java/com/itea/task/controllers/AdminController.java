package com.itea.task.controllers;

import com.itea.task.dto.UserDto;
import com.itea.task.entities.UserEntity;
import com.itea.task.mapper.UserMapper;
import com.itea.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class AdminController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper mapper;

    private static final String NOT_FOUND_MESSAGE = "No user found for ID: ";

    @GetMapping
    @PreAuthorize("hasRole('ROLE_LESSON_ADMIN') or hasRole('ROLE_LESSON_USER')")
    public List<UserDto> getUsers() {
        List<UserEntity> entities = service.findAll();
        List<UserDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapper.toDto(e)));
        return dtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        return isNull(service.get(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(mapper.toDto(service.get(id)), OK);
    }

    @PostMapping
    @Secured("ROLE_LESSON_ADMIN")
    public ResponseEntity<?> addUser(@RequestBody UserDto user) {
        service.add(mapper.toEntity(user));
        return new ResponseEntity<>(user, OK);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_LESSON_ADMIN")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        return isNull(service.delete(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(id, OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_LESSON_ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user) {
        user = mapper.toDto(service.update(id, mapper.toEntity((user))));
        return isNull(user) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(user, OK);
    }
}
