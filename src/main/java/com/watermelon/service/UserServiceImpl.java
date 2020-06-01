package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.*;
import com.watermelon.mapper.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SupervisorMapper supervisorMapper;

    @Override
    public int registerUser(String username,String password){
        int count = userMapper.getMaxUserId();
        User user = new User();
        user.setId(count+1);
        user.setName(username);
//        user.setPassword(password);
        user.setPassword(encodeMD5(password));
        return addUser(user);
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        user.setRole(roleMapper.getRoleById(user.getRoleId()));
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = userMapper.getUserByName(name);
        user.setRole(roleMapper.getRoleById(user.getRoleId()));
        return user;
    }

    @Override
    public String getNameById(int id) {
        String name = "";
        User user = userMapper.getUserById(id);
        switch (user.getRoleId()) {
            case 1:
                name = adminMapper.getAdminById(id).getName();
                break;
            case 2:
                name = teacherMapper.getTeacherById(id).getName();
                break;
            case 3:
                name = studentMapper.getStudentById(id).getName();
                break;
            case 4:
                name = supervisorMapper.getSupervisorById(id).getName();
                break;
        }
        return name;
    }

    @Override
    public int addUser(User user) {
        user.setRoleId(user.getRole().getId());
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        User user1 = userMapper.getUserById(user.getId());
        if (user1==null){
            return -1;
        }
        //当检查到用户角色改变时修改数据库中用户的身份
        updateUserInfo(user1, user);
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<User> listUser(int startPage, int pageSize) {
        Page<User> page = new Page<>(startPage,pageSize);
        List<User> list = userMapper.listUser(page);
        for (User user : list){
            Role role = roleService.getRoleById(user.getRoleId());
            user.setRole(role);
        }
        return list;
    }

    @Override
    public int getMaxUserId() {
        return getMaxUserId();
    }

    /**
     * 当新的用户角色和原本角色不同时，修改角色的数据库信息（有待完善级联删除）
     * @param user1 数据库原本保留的用户身份信息
     * @param user  回传的新的用户身份信息
     */
    private void updateUserInfo(User user1,User user){
        if (user1.getRoleId()!=user.getRole().getId()){
            //删除原有用户信息
            switch (user1.getRole().getId()){
                case 1:
                    adminMapper.deleteAdmin(user1.getId());
                    break;
                case 2:
                    teacherMapper.deleteTeacher(user1.getId());
                    break;
                case 3:
                    studentMapper.deleteStudent(user1.getId());
                    break;
                case 4:
                    supervisorMapper.deleteSupervisor(user1.getId());
                    break;
            }
            //添加新的用户信息
            switch (user.getRole().getId()){
                case 1:
                    Admin admin = new Admin(user);
                    adminMapper.addAdmin(admin);
                    break;
                case 2:
                    Teacher teacher = new Teacher(user);
                    teacherMapper.addTeacher(teacher);
                    break;
                case 3:
                    Student student = new Student(user);
                    studentMapper.addStudent(student);
                    break;
                case 4:
                    Supervisor supervisor = new Supervisor(user);
                    supervisorMapper.addSupervisor(supervisor);
                    break;
            }
        }
    }

    /**
     * 使用Shiro提供的Md5Hash类对密码进行加密
     * @param password
     * @return
     */
    public String encodeMD5(String password){
        return  new Md5Hash(password).toHex();
    }

    /**
     * 使用Shiro提供的Md5Hash类对密码进行盐值加密,此处盐值为username
     * @param password
     * @param salt
     * @return
     */
    public String encodeMD5Salt(String password,String salt){
        return  new Md5Hash(password,salt,1).toHex();
    }

}
