package com.stc.petlove.services;

import com.stc.petlove.dtos.DatChoDto;
import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.repositories.DatChoRepository;
import com.stc.petlove.utils.EnumTrangThaiDatCho;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class DatChoServiceImplement implements DatChoService{
    public final DatChoRepository datChoRepository;

    public DatChoServiceImplement(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public void addEntity(DatChoDto datChoDto) {
        datChoRepository.save(new DatCho(datChoDto.getId(), datChoDto.getEmail(), datChoDto.getThoiGian(),
                datChoDto.getCanDan(), EnumTrangThaiDatCho.DAT_CHO.toString(), true));
    }

    @Override
    public void updateEntity(DatChoDto datChoDto) {
        Random random = new Random();
        datChoRepository.save(new DatCho(datChoDto.getId(), datChoDto.getEmail(), datChoDto.getThoiGian(),
                datChoDto.getCanDan(), EnumTrangThaiDatCho.values()[random.nextInt(3)].toString(), true));
    }

    @Override
    public DatChoDto getEntity(String id) {
        DatChoDto datChoDto = new DatChoDto();
        Optional<DatCho> temp = datChoRepository.findById(id);
        if (temp.isPresent()){
            DatCho dc = temp.get();
            datChoDto = new DatChoDto(dc.getId(), dc.getEmail(), dc.getThongTinDatChos(), dc.getThoiGian(),
                    dc.getCanDan(), dc.getTrangThaiDatCho(), dc.isTrangThai());
        }
        return datChoDto;
    }

    @Override
    public void deleteEntity(String id) {
        if (datChoRepository.existsById(id)){
            datChoRepository.deleteById(id);
        }
    }
}
