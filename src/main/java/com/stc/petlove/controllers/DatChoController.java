package com.stc.petlove.controllers;

import com.stc.petlove.dtos.datcho.DatChoDto;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.services.datcho.DatChoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/dat-cho")
public class DatChoController {
    private final DatChoService datChoService;

    public DatChoController(DatChoService datChoService) {
        this.datChoService = datChoService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatCho> getDatCho(@PathVariable String id) {
        return new ResponseEntity<>(datChoService.getDatCho(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DatCho> create(@Valid @RequestBody DatChoDto dto) {
        return new ResponseEntity<>(datChoService.create(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatCho> update(@PathVariable String id, @Valid @RequestBody DatChoDto dto) {
        return new ResponseEntity<>(datChoService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DatCho> delete(@PathVariable String id) {
        return new ResponseEntity<>(datChoService.delete(id), HttpStatus.OK);
    }
}
