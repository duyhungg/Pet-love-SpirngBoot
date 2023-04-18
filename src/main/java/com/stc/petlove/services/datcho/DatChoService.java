package com.stc.petlove.services.datcho;

import com.stc.petlove.dtos.datcho.DatChoDto;
import com.stc.petlove.entities.DatCho;

public interface DatChoService {
    DatCho getDatCho(String id);

    DatCho create (DatChoDto dto);

    DatCho update (String id, DatChoDto dto);

    DatCho delete (String id);
}
