package com.stc.petlove.controller;

import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.dtos.ResponseDto;
import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.services.LoaiThuCungServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/loaithucung")
public class LoaiThuCungController {
    private final LoaiThuCungServiceImplement loaiThuCungService;

    public LoaiThuCungController(LoaiThuCungServiceImplement loaiThuCungService) {
        this.loaiThuCungService = loaiThuCungService;
    }

    @PostMapping("add")
    public ResponseEntity<?> createSomething(@Valid @RequestBody LoaiThuCungDto loaiThuCungDto){
        loaiThuCungService.addEntity(loaiThuCungDto);
        return new ResponseEntity<>
                (new ResponseDto("Create", "Succeed", loaiThuCungDto), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseDto> readSomething(@RequestParam String id){
        LoaiThuCungDto loaiThuCungDto = new LoaiThuCungDto();
        loaiThuCungDto = loaiThuCungService.getEntity(id);
        return new ResponseEntity<>
                (new ResponseDto("Read", "Succeed", loaiThuCungDto), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<?> updateSomething(@Valid @RequestBody LoaiThuCungDto loaiThuCungDto){
        loaiThuCungService.updateEntity(loaiThuCungDto);
        return new ResponseEntity<>
                (new ResponseDto("Update", "Succeed", loaiThuCungDto), HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseDto> deleteSomething(@RequestParam String id){
        loaiThuCungService.deleteEntity(id);
        return new ResponseEntity<>
                (new ResponseDto("Delete", "Succeed", null), HttpStatus.OK);
    }
}
