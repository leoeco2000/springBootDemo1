package config.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import config.springsecurity.entity.SRole;

@Repository
public interface SRoleRepository extends JpaRepository<SRole, Integer> {



}
