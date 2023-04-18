package com.stc.petlove.services;

import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.dtos.TaiKhoanDto;

public interface LoaiThuCungService {
    void addEntity(LoaiThuCungDto loaiThuCungDto);

    void updateEntity(LoaiThuCungDto loaiThuCungDto);

    LoaiThuCungDto getEntity(String id);

    void deleteEntity(String id);
}
