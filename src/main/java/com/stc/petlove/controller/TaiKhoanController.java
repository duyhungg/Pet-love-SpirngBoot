package com.stc.petlove.controller;

import com.stc.petlove.dtos.ResponseDto;
import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.services.TaiKhoanServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {
    private final TaiKhoanServiceImplement taiKhoanService;

    public TaiKhoanController(TaiKhoanServiceImplement taiKhoanServiceImplement) {
        this.taiKhoanService = taiKhoanServiceImplement;
    }

    @PostMapping("add")
    public ResponseEntity<?> createSomething(@Valid @RequestBody TaiKhoanDto taiKhoanDto){
        taiKhoanService.addTaiKhoan(taiKhoanDto);
        return new ResponseEntity<>
                (new ResponseDto("Create", "Succeed", taiKhoanDto), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseDto> readSomething(@RequestParam String tkId){
        TaiKhoanDto taiKhoanDto = new TaiKhoanDto();
        taiKhoanDto = taiKhoanService.getTaiKhoan(tkId);
        return new ResponseEntity<>
                (new ResponseDto("Read", "Succeed", taiKhoanDto), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<?> updateSomething(@Valid @RequestBody TaiKhoanDto taiKhoanDto){
        taiKhoanService.updateTaiKhoan(taiKhoanDto);
        return new ResponseEntity<>
                (new ResponseDto("Update", "Succeed", taiKhoanDto), HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<ResponseDto> deleteSomething(@RequestParam String tkId){
        taiKhoanService.deleteTaiKhoan(tkId);
        return new ResponseEntity<>
                (new ResponseDto("Delete", "Succeed", null), HttpStatus.OK);
    }
}
