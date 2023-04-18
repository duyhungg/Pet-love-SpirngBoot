package com.stc.petlove.entities;

import com.stc.petlove.entities.embedded.ThongTinDatCho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 4/11/23
 * Time      : 9:37 PM
 * Filename  : DatCho
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dat-cho")
public class DatCho {
    @Id
    private String id;

    // email người đặt chỗ
    private String email;

    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();

    // Thời gian chăm sóc thú cưng
    private Date thoiGian;

    // căn dặn khi chăm sóc thú cưng
    private String canDan;

    // lấy từ enum trạng thái đặt chỗ
    private String trangThaiDatCho;

    private boolean trangThai = true;
}
