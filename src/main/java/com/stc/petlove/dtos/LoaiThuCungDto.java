package com.stc.petlove.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiThuCungDto {
    private String id;

    private String maLoaiThuCung;

    private String tenLoaiThuCung;

    private Boolean trangThai = true;
}
