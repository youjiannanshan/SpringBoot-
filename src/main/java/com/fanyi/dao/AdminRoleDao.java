package com.fanyi.dao;

import com.fanyi.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRoleDao extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
