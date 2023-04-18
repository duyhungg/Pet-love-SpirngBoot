package com.stc.petlove.services;

import com.stc.petlove.dtos.TaiKhoanDto;

public interface TaiKhoanService {
    void addTaiKhoan(TaiKhoanDto taiKhoanDto);

    void updateTaiKhoan(TaiKhoanDto taiKhoanDto);

    TaiKhoanDto getTaiKhoan(String tkId);

    void deleteTaiKhoan(String tkId);
}
