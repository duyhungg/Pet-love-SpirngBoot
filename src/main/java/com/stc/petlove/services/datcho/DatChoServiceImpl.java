package com.stc.petlove.services.datcho;

import com.stc.petlove.dtos.datcho.DatChoDto;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.exceptions.InvalidException;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.DatChoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class DatChoServiceImpl implements DatChoService {

    private final DatChoRepository datChoRepository;

    public DatChoServiceImpl(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public DatCho getDatCho(String id) {
        return datChoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Đặt chỗ có id %s không tồn tại", id)));
    }

    @Override
    public DatCho create(DatChoDto dto) {
        DatCho datCho = new DatCho();
        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new InvalidException("Email đặt chỗ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinDatChos())) {
            throw new InvalidException("Thông tin đặt chỗ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThoiGian())) {
            throw new InvalidException("Thời gian đặt chỗ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getCanDan())) {
            throw new InvalidException("Căn dặn không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTrangThaiDatCho())) {
            throw new InvalidException("Trạng thái đặt chỗ không được bỏ trống");
        }

        datCho.setEmail(dto.getEmail().trim());
        datCho.setThongTinDatChos(dto.getThongTinDatChos());
        datCho.setThoiGian(dto.getThoiGian());
        datCho.setCanDan(dto.getCanDan().trim());
        datCho.setTrangThaiDatCho(dto.getTrangThaiDatCho().trim());
        datChoRepository.save(datCho);
        return datCho;
    }


    @Override
    public DatCho update(String id, DatChoDto dto) {
        DatCho datCho = getDatCho(id);
        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new InvalidException("Email đặt chỗ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinDatChos())) {
            throw new InvalidException("Thông tin đặt chỗ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThoiGian())) {
            throw new InvalidException("Thời gian đặt chỗ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getCanDan())) {
            throw new InvalidException("Căn dặn không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTrangThaiDatCho())) {
            throw new InvalidException("Trạng thái đặt chỗ không được bỏ trống");
        }

        datCho.setEmail(dto.getEmail().trim());
        datCho.setThongTinDatChos(dto.getThongTinDatChos());
        datCho.setThoiGian(dto.getThoiGian());
        datCho.setCanDan(dto.getCanDan().trim());
        datCho.setTrangThaiDatCho(dto.getTrangThaiDatCho().trim());
        datChoRepository.save(datCho);
        return datCho;
    }

    @Override
    public DatCho delete(String id) {
        DatCho datCho = getDatCho(id);
        datChoRepository.delete(datCho);
        return datCho;
    }
}
