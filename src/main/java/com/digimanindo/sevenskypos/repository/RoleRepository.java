package com.digimanindo.sevenskypos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimanindo.sevenskypos.models.ERole;
import com.digimanindo.sevenskypos.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
