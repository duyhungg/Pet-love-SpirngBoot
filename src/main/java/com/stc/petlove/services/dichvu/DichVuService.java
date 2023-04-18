package com.stc.petlove.services.dichvu;

import com.stc.petlove.dtos.datcho.DatChoDto;
import com.stc.petlove.dtos.dichvu.DichVuDto;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.DichVu;

public interface DichVuService {
    DichVu getDichVu(String id);

    DichVu create (DichVuDto dto);

    DichVu update (String id, DichVuDto dto);

    DichVu delete (String id);
}
