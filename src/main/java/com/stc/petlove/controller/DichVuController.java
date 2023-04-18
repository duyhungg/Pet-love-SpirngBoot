package com.stc.petlove.controller;

import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.dtos.ResponseDto;
import com.stc.petlove.services.DichVuServiceImplement;
import com.stc.petlove.services.LoaiThuCungServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dichvu")
public class DichVuController {
    private final DichVuServiceImplement dichVuService;

    public DichVuController(DichVuServiceImplement dichVuService) {
        this.dichVuService = dichVuService;
    }

    @PostMapping("add")
    public ResponseEntity<?> createSomething(@Valid @RequestBody DichVuDto dichVuDto){
        dichVuService.addEntity(dichVuDto);
        return new ResponseEntity<>
                (new ResponseDto("Create", "Succeed", dichVuDto), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseDto> readSomething(@RequestParam String id){
        DichVuDto dichVuDto = new DichVuDto();
        dichVuDto = dichVuService.getEntity(id);
        return new ResponseEntity<>
                (new ResponseDto("Read", "Succeed", dichVuDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateSomething(@Valid @RequestBody DichVuDto dichVuDto){
        dichVuService.updateEntity(dichVuDto);
        return new ResponseEntity<>
                (new ResponseDto("Update", "Succeed", dichVuDto), HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseDto> deleteSomething(@RequestParam String id){
        dichVuService.deleteEntity(id);
        return new ResponseEntity<>
                (new ResponseDto("Delete", "Succeed", null), HttpStatus.OK);
    }
}
