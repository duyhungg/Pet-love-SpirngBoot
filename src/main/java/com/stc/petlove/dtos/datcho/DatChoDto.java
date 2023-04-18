package com.stc.petlove.dtos.datcho;

import com.stc.petlove.entities.embedded.ThongTinDatCho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatChoDto {
    private String email;

    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();

    private Date thoiGian;

    private String canDan;

    private String trangThaiDatCho;
}
