package com.stc.petlove.repositories;

import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung, String> {
    @Query(value = "{'maDichVu': ?0}", exists = true)
    boolean kiemTraMaLoaiThuCung(String maLoaiThuCung);
}
