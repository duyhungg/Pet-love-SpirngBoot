package com.stc.petlove.entities;

import com.stc.petlove.entities.embedded.GiaDichVu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 4/11/23
 * Time      : 9:35 PM
 * Filename  : DichVu
 */
@Getter
@Setter
@Document(collection = "dich-vu")
public class DichVu {
    @Id
    private String id;

    // mã dịch vụ không được trùng
    @Indexed(unique = true)
    private String maDichVu;

    private String tenDichVu;

    // nội dung là html
    private String noiDung;

    // Giá dịch vụ phụ thuộc vào loại thú cưng và cân nặng của thú cưng
    private List<GiaDichVu> giaDichVus = new ArrayList<>();

    private boolean trangThai = true;
//    Constructor

    public DichVu(String id, String maDichVu, String tenDichVu, String noiDung, boolean trangThai) {
        this.id = id;
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.noiDung = noiDung;
        this.trangThai = trangThai;
        giaDichVus.add(new GiaDichVu("tc1", 10, 100));
        giaDichVus.add(new GiaDichVu("tc2", 10, 200));
    }

    public DichVu() {
        giaDichVus.add(new GiaDichVu("tc1", 10, 100));
        giaDichVus.add(new GiaDichVu("tc2", 10, 200));
    }
}
