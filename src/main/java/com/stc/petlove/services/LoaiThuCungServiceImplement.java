package com.stc.petlove.services;

import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.repositories.LoaiThuCungRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiThuCungServiceImplement implements LoaiThuCungService{
    private final LoaiThuCungRepository loaiThuCungRepository;

    public LoaiThuCungServiceImplement(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }

    @Override
    public void addEntity(LoaiThuCungDto loaiThuCungDto) {
        loaiThuCungRepository.insert(new LoaiThuCung(loaiThuCungDto.getId(), loaiThuCungDto.getMaLoaiThuCung(),
                loaiThuCungDto.getTenLoaiThuCung(), loaiThuCungDto.getTrangThai()));
    }

    @Override
    public void updateEntity(LoaiThuCungDto loaiThuCungDto) {
        loaiThuCungRepository.save(new LoaiThuCung(loaiThuCungDto.getId(), loaiThuCungDto.getMaLoaiThuCung(),
                loaiThuCungDto.getTenLoaiThuCung(), loaiThuCungDto.getTrangThai()));
    }

    @Override
    public LoaiThuCungDto getEntity(String id) {
        LoaiThuCungDto loaiThuCungDto = new LoaiThuCungDto();
        Optional<LoaiThuCung> temp = loaiThuCungRepository.findById(id);
        if (temp.isPresent()){
            LoaiThuCung loaiThuCung = temp.get();
            loaiThuCungDto = new LoaiThuCungDto(loaiThuCung.getId(), loaiThuCung.getMaLoaiThuCung(),
                    loaiThuCung.getTenLoaiThuCung(), loaiThuCung.getTrangThai());
        }
        return loaiThuCungDto;
    }

    @Override
    public void deleteEntity(String id) {
        if (loaiThuCungRepository.existsById(id)){
            loaiThuCungRepository.deleteById(id);
        }
    }
}
