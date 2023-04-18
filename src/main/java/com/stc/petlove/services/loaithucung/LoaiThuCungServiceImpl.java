package com.stc.petlove.services.loaithucung;

import com.stc.petlove.dtos.loaithucung.LoaiThuCungDto;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exceptions.InvalidException;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.LoaiThuCungRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class LoaiThuCungServiceImpl implements LoaiThuCungService{
    private final LoaiThuCungRepository loaiThuCungRepository;

    public LoaiThuCungServiceImpl(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }

    @Override
    public LoaiThuCung getLoaiThuCung(String id) {
        return loaiThuCungRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Loại thú cưng có id %s không tồn tại", id)));
    }

    @Override
    public LoaiThuCung create(LoaiThuCungDto dto) {
        if (ObjectUtils.isEmpty(dto.getMaLoaiThuCung())) {
            throw new InvalidException("Mã loại thú cưng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTenLoaiThuCung())) {
            throw new InvalidException("Tên loại thú cưng không được bỏ trống");
        }
        if (loaiThuCungRepository.kiemTraMaLoaiThuCung(dto.getMaLoaiThuCung().trim().toUpperCase())) {
            throw new InvalidException(String.format("Loại thú cưng có mã %s đã tồn tại",
                    dto.getMaLoaiThuCung()));
        }
        LoaiThuCung loaiThuCung = new LoaiThuCung();
        loaiThuCung.setMaLoaiThuCung(dto.getMaLoaiThuCung().trim().toUpperCase());
        loaiThuCung.setTenLoaiThuCung(dto.getTenLoaiThuCung().trim());
        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung update(String id, LoaiThuCungDto dto) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        if (ObjectUtils.isEmpty(dto.getMaLoaiThuCung())) {
            throw new InvalidException("Mã loại thú cưng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTenLoaiThuCung())) {
            throw new InvalidException("Tên loại thú cưng không được bỏ trống");
        }
        if (!loaiThuCung.getMaLoaiThuCung().equalsIgnoreCase(dto.getMaLoaiThuCung().trim())
                && loaiThuCungRepository.kiemTraMaLoaiThuCung(dto.getMaLoaiThuCung().trim().toUpperCase())) {
            throw new InvalidException(String.format("Loại thú cưng có mã %s đã tồn tại",
                    dto.getMaLoaiThuCung()));
        }
        loaiThuCung.setMaLoaiThuCung(dto.getMaLoaiThuCung().trim().toUpperCase());
        loaiThuCung.setTenLoaiThuCung(dto.getTenLoaiThuCung().trim());
        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung delete(String id) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        loaiThuCungRepository.delete(loaiThuCung);
        return loaiThuCung;
    }
}
