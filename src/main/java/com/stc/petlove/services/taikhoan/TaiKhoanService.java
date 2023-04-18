package com.stc.petlove.services.taikhoan;

import com.stc.petlove.dtos.taikhoan.TaiKhoanDto;
import com.stc.petlove.entities.TaiKhoan;

public interface TaiKhoanService {
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan create (TaiKhoanDto dto);

    TaiKhoan update (String id, TaiKhoanDto dto);

    TaiKhoan delete (String id);
}
