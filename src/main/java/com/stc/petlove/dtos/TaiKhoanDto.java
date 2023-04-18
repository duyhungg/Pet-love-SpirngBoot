package com.stc.petlove.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanDto {

    String id;
    String name;
    String email;
    String password;
    String dienThoai;
    List<String> roles;
    Boolean trangThai;
}
