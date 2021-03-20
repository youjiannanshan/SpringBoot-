package com.fanyi.service;

import com.fanyi.dao.AdminRoleDao;
import com.fanyi.pojo.AdminMenu;
import com.fanyi.pojo.AdminPermission;
import com.fanyi.pojo.AdminRole;
import com.fanyi.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDao adminRoleDao;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminMenuService adminMenuService;

    public List<AdminRole> listWithPermsAndMenus() {
        List<AdminRole> roles = adminRoleDao.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public List<AdminRole> findAll() {
        return adminRoleDao.findAll();
    }


    public void addOrUpdate(AdminRole adminRole) {
        adminRoleDao.save(adminRole);
    }

    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.getByName(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        return adminRoleDao.findAllById(rids);
    }

    public AdminRole updateRoleStatus(AdminRole role) {
        AdminRole roleInDB = adminRoleDao.findById(role.getId());
        roleInDB.setEnabled(role.isEnabled());
        return adminRoleDao.save(roleInDB);
    }

    public void editRole(@RequestBody AdminRole role) {
        adminRoleDao.save(role);
        adminRolePermissionService.savePermChanges(role.getId(), role.getPerms());
    }
}
