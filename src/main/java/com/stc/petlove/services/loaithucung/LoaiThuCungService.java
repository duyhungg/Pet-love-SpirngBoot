package com.stc.petlove.services.loaithucung;

import com.stc.petlove.dtos.datcho.DatChoDto;
import com.stc.petlove.dtos.loaithucung.LoaiThuCungDto;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.LoaiThuCung;

public interface LoaiThuCungService {
    LoaiThuCung getLoaiThuCung(String id);
    LoaiThuCung create (LoaiThuCungDto dto);

    LoaiThuCung update (String id, LoaiThuCungDto dto);

    LoaiThuCung delete (String id);
}
