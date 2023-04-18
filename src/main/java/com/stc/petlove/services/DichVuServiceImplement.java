package com.stc.petlove.services;

import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.entities.embedded.GiaDichVu;
import com.stc.petlove.repositories.DichVuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImplement implements DichVuService{
    public final DichVuRepository dichVuRepository;

    public DichVuServiceImplement(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }


    @Override
    public void addEntity(DichVuDto dichVuDto) {
        dichVuRepository.insert(new DichVu(dichVuDto.getId(), dichVuDto.getMaDichVu(), dichVuDto.getTenDichVu(),
                dichVuDto.getNoiDung(), dichVuDto.isTrangThai()));
    }

    @Override
    public void updateEntity(DichVuDto dichVuDto) {
        dichVuRepository.save(new DichVu(dichVuDto.getId(), dichVuDto.getMaDichVu(), dichVuDto.getTenDichVu(),
                dichVuDto.getNoiDung(), dichVuDto.isTrangThai()));
    }

    @Override
    public DichVuDto getEntity(String id) {
        DichVuDto dichVuDto = new DichVuDto();
        Optional<DichVu> temp = dichVuRepository.findById(id);
        if (temp.isPresent()){
            DichVu dichVu = temp.get();
            dichVuDto = new DichVuDto(dichVu.getId(), dichVu.getMaDichVu(), dichVu.getTenDichVu(),
                    dichVu.getNoiDung(), dichVu.getGiaDichVus(), dichVu.isTrangThai());
        }
        return dichVuDto;
    }

    @Override
    public void deleteEntity(String id) {
        if (dichVuRepository.existsById(id)){
            dichVuRepository.deleteById(id);
        }
    }
}
