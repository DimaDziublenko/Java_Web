package com.itea.task.controllers;

import com.itea.task.dtos.CompanyDto;
import com.itea.task.entities.CompanyEntity;
import com.itea.task.mappers.CompanyMapper;
import com.itea.task.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService service;

    @Autowired
    private CompanyMapper mapper;

    private static final String NOT_FOUND_MESSAGE = "No company found for ID: ";

    @GetMapping("/companies")
    public List<CompanyDto> getCompanies() {
        List<CompanyEntity> entities = service.findAll();
        List<CompanyDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapper.toDto(e)));
        return dtos;
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<?> getCompany(@PathVariable("id") Long id) {
        return isNull(service.get(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(mapper.toDto(service.get(id)), OK);
    }

    @PostMapping("/companies")
    public ResponseEntity<?> addCompany(@RequestBody CompanyDto company) {
        service.add(mapper.toEntity(company));
        return new ResponseEntity<>(company, OK);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id) {
        return isNull(service.delete(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(id, OK);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable("id") Long id, @RequestBody CompanyDto company) {
        company = mapper.toDto(service.update(id, mapper.toEntity(company)));
        return isNull(company) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(company, OK);
    }
}
