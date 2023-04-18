package com.stc.petlove.controller;

import com.stc.petlove.dtos.DatChoDto;
import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.dtos.ResponseDto;
import com.stc.petlove.services.DatChoServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/datcho")
public class DatChoController {
    private final DatChoServiceImplement datChoService;

    public DatChoController(DatChoServiceImplement datChoService) {
        this.datChoService = datChoService;
    }


    @PostMapping("add")
    public ResponseEntity<?> createSomething(@Valid @RequestBody DatChoDto datChoDto){
        datChoService.addEntity(datChoDto);
        return new ResponseEntity<>
                (new ResponseDto("Create", "Succeed", datChoDto), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseDto> readSomething(@RequestParam String id){
        DatChoDto datChoDto = new DatChoDto();
        datChoDto = datChoService.getEntity(id);
        return new ResponseEntity<>
                (new ResponseDto("Read", "Succeed", datChoDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateSomething(@Valid @RequestBody DatChoDto datChoDto){
        datChoService.updateEntity(datChoDto);
        return new ResponseEntity<>
                (new ResponseDto("Update", "Succeed", datChoDto), HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseDto> deleteSomething(@RequestParam String id){
        datChoService.deleteEntity(id);
        return new ResponseEntity<>
                (new ResponseDto("Delete", "Succeed", null), HttpStatus.OK);
    }
}
