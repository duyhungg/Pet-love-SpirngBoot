package com.stc.petlove.services;

import com.stc.petlove.dtos.DatChoDto;
import com.stc.petlove.dtos.DichVuDto;

public interface DatChoService {
    void addEntity(DatChoDto datChoDto);

    void updateEntity(DatChoDto datChoDto);

    DatChoDto getEntity(String id);

    void deleteEntity(String id);
}
