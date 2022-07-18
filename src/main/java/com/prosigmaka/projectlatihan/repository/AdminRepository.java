package com.prosigmaka.projectlatihan.repository;

import com.prosigmaka.projectlatihan.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findByUsernameAndPassword(String uname, String pass);
}
