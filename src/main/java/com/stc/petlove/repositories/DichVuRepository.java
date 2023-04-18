package com.stc.petlove.repositories;

import com.stc.petlove.entities.DichVu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DichVuRepository extends MongoRepository<DichVu, String> {
    @Query(value = "{'maDichVu': ?0}", exists = true)
    boolean kiemTraMaDichVu(String maDichVu);

}
