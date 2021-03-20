package com.fanyi.dao;

import com.fanyi.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPermissionDao extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
