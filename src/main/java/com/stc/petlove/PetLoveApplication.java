package com.stc.petlove;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.repositories.TaiKhoanRepository;
import com.stc.petlove.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PetLoveApplication implements CommandLineRunner {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetLoveApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if(taiKhoanRepository.count()==0){
            TaiKhoan taiKhoan = new TaiKhoan("hungdc","20110072@student.hcmute.edu.vn","123456789",
                    Arrays.asList(EnumRole.ROLE_ADMIN.name()));
            taiKhoanRepository.save(taiKhoan);
        }
    }
}
