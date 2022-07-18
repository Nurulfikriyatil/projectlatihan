package com.prosigmaka.projectlatihan.controller;

import com.prosigmaka.projectlatihan.model.dto.DefaultResponse;
import com.prosigmaka.projectlatihan.model.dto.LoginDto;
import com.prosigmaka.projectlatihan.model.entity.Admin;
import com.prosigmaka.projectlatihan.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public DefaultResponse login(@RequestBody LoginDto loginDto) {

        Optional<Admin> optionalAdmin = adminRepository.findByUsernameAndPassword(loginDto.getUname(), loginDto.getPass());

        DefaultResponse df = new DefaultResponse();
        if(optionalAdmin.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Berhasil Login");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Maaf Username atau Password salah");
        }
        return df;

    }
    @GetMapping("/byid/{nim}")
    public DefaultResponse getByIdAdmin(@PathVariable String nim) {
        DefaultResponse df = new DefaultResponse();
        Optional<Admin> admOps = adminRepository.findById(nim);
        if(admOps.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data ditemukan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data tidak ada");
        }
        return df;

    }
}
