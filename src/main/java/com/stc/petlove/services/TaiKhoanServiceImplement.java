package com.stc.petlove.services;

import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.repositories.TaiKhoanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaiKhoanServiceImplement implements TaiKhoanService{

    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanServiceImplement(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public void addTaiKhoan(TaiKhoanDto taiKhoanDto) {
        taiKhoanRepository
                .insert(new TaiKhoan(taiKhoanDto.getId(), taiKhoanDto.getName(), taiKhoanDto.getEmail(),
                        taiKhoanDto.getEmail(), taiKhoanDto.getDienThoai(), taiKhoanDto.getRoles(),
                        taiKhoanDto.getTrangThai()));
    }

    @Override
    public void updateTaiKhoan(TaiKhoanDto taiKhoanDto) {
        taiKhoanRepository
                .save(new TaiKhoan(taiKhoanDto.getId(), taiKhoanDto.getName(), taiKhoanDto.getEmail(),
                        taiKhoanDto.getEmail(), taiKhoanDto.getDienThoai(), taiKhoanDto.getRoles(),
                        taiKhoanDto.getTrangThai()));
    }

    @Override
    public TaiKhoanDto getTaiKhoan(String tkId) {
        TaiKhoanDto taiKhoanDto = new TaiKhoanDto();
        Optional<TaiKhoan> temp = taiKhoanRepository.findById(tkId);
        if (temp.isPresent()){
            TaiKhoan tk = temp.get();
            taiKhoanDto.setId(tk.getId());
            taiKhoanDto.setName(tk.getName());
            taiKhoanDto.setRoles(tk.getRoles());
            taiKhoanDto.setEmail(tk.getEmail());
            taiKhoanDto.setPassword(tk.getPassword());
            taiKhoanDto.setDienThoai(tk.getDienThoai());
            taiKhoanDto.setTrangThai(tk.isTrangThai());
        }
        return taiKhoanDto;
    }

    @Override
    public void deleteTaiKhoan(String tkId) {
        if (taiKhoanRepository.existsById(tkId)){
            taiKhoanRepository.deleteById(tkId);
        }
    }
}
