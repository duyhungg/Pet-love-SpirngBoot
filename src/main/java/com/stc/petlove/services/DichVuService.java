package com.stc.petlove.services;

import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.dtos.LoaiThuCungDto;

public interface DichVuService {
    void addEntity(DichVuDto dichVuDto);

    void updateEntity(DichVuDto dichVuDto);

    DichVuDto getEntity(String id);

    void deleteEntity(String id);
}
