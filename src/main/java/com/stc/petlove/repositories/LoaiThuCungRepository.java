package com.stc.petlove.repositories;

import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung, String> {
}
