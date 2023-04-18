package com.stc.petlove.services.dichvu;

import com.stc.petlove.dtos.dichvu.DichVuDto;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.exceptions.InvalidException;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.DichVuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class DichVuServiceImpl implements DichVuService {
    private final DichVuRepository dichVuRepository;

    public DichVuServiceImpl(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @Override
    public DichVu getDichVu(String id) {
        return dichVuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Dịch vụ có id %s không tồn tại", id)));
    }

    @Override
    public DichVu create(DichVuDto dto) {
        if (ObjectUtils.isEmpty(dto.getMaDichVu())) {
            throw new InvalidException("Mã dịch vụ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTenDichVu())) {
            throw new InvalidException("Tên dịch vụ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNoiDung())) {
            throw new InvalidException("Nội dung không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getGiaDichVus())) {
            throw new InvalidException("Giá dịch vụ không được bỏ trống");
        }
        if (dichVuRepository.kiemTraMaDichVu(dto.getMaDichVu().trim().toUpperCase())) {
            throw new InvalidException(String.format("Loại câu hỏi có mã %s đã tồn tại",
                    dto.getMaDichVu()));
        }
        DichVu dichVu = new DichVu();
        dichVu.setMaDichVu(dto.getMaDichVu().trim().toUpperCase());
        dichVu.setTenDichVu(dto.getTenDichVu().trim());
        dichVu.setNoiDung(dto.getNoiDung().trim());
        dichVu.setGiaDichVus(dto.getGiaDichVus());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu update(String id, DichVuDto dto) {
        DichVu dichVu = getDichVu(id);
        if (ObjectUtils.isEmpty(dto.getMaDichVu())) {
            throw new InvalidException("Mã dịch vụ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTenDichVu())) {
            throw new InvalidException("Tên dịch vụ không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNoiDung())) {
            throw new InvalidException("Nội dung không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getGiaDichVus())) {
            throw new InvalidException("Giá dịch vụ không được bỏ trống");
        }
        if (!dichVu.getMaDichVu().equalsIgnoreCase(dto.getMaDichVu().trim())
                && dichVuRepository.kiemTraMaDichVu(dto.getMaDichVu().trim().toUpperCase())) {
            throw new InvalidException(String.format("Loại câu hỏi có mã %s đã tồn tại",
                    dto.getMaDichVu()));
        }
        dichVu.setMaDichVu(dto.getMaDichVu().trim().toUpperCase());
        dichVu.setTenDichVu(dto.getTenDichVu().trim());
        dichVu.setNoiDung(dto.getNoiDung().trim());
        dichVu.setGiaDichVus(dto.getGiaDichVus());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu delete(String id) {
        DichVu dichVu = getDichVu(id);
        dichVuRepository.delete(dichVu);
        return dichVu;
    }
}
