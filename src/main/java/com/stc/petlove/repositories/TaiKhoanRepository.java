package com.stc.petlove.repositories;

import com.stc.petlove.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {

}
