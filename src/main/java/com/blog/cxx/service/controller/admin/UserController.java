package com.blog.cxx.service.controller.admin;


import com.blog.cxx.service.entity.Role;
import com.blog.cxx.service.entity.User;
import com.blog.cxx.service.entity.vo.MenuInfo;
import com.blog.cxx.service.entity.vo.UserInfo;
import com.blog.cxx.service.mapper.MenuMapper;
import com.blog.cxx.service.mapper.RoleMapper;
import com.blog.cxx.service.mapper.UserMapper;
import com.blog.cxx.service.mapper.UserRoleMapper;
import com.blog.cxx.service.result.R;
import com.blog.cxx.service.service.RoleService;
import com.blog.cxx.service.service.UserRoleService;
import com.blog.cxx.service.service.UserService;
import com.blog.cxx.service.utils.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Cxx
 * @since 2022-01-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private MenuMapper menuMapper;

    @ApiOperation("增加用户信息")
    @PostMapping("/create")
    public R createUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().length() == 0
                || user.getPassword() == null || user.getPassword().length() == 0) {
            return R.error().message("请输入用户名和密码");
        }

        List<User> userList = userService.query("username", user.getUsername());

        if (userList.size() != 0) {
            return R.error().message("用户已存在");
        } else {
            // 增加用户
            Integer result = userService.create(user);
            if (result != 0) {
                return R.ok().message("增加成功");
            } else {
                return R.error().message("增加失败");
            }
        }
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete")
    public R deleteUser(String username) {
        if (username == null || username.length() == 0) {
            return R.error().message("请输入用户名");
        }

        List<User> userList = userService.query("username", username);

        if (userList.size() == 0) {
            return R.error().message("用户不存在");
        } else {
            // 删除用户和角色
            Boolean result = userService.delete("username", username);

            if (result) {
                return R.ok().message("删除成功");
            } else {
                return R.error().message("删除失败");
            }
        }
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    public R updateUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().length() == 0) {
            return R.error().message("请输入用户名");
        }

        List<User> userList = userService.query("username", user.getUsername());
        if (userList.size() == 0) {
            return R.error().message("用户不存在");
        }

        // 数据库中的User信息
        User dbUser = userList.get(0);
        // 更新用户信息
        Integer update = userService.update(user, dbUser);

        if (update != 0) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }

    @ApiOperation("查询用户信息")
    @GetMapping("/read")
    public R readUser(String username) {
        if (username == null || username.length() == 0) {
            return R.error().message("请输入用户名");
        }

        List<User> userList = userService.query("username", username);
        if (userList.size() == 0) {
            return R.error().message("用户不存在");
        } else {
            return R.ok().data("data", userList);
        }
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return R.error().message("账号密码不能为空");
        }

        String token = userService.login(user);

        // 向前端返回token字符串
        return R.ok().data("token", token);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public R logOut(@RequestHeader("X-Token") String token) {
        SecurityUtils.getSubject().logout();
        return R.ok().message("退出登录成功");
    }

    @ApiOperation("获取用户角色信息")
    @GetMapping("/getRoleInfo")
    // 这里需要token参数，此时前端还不知道用户的信息，只有token信息
    public R getRoleInfo(@RequestHeader("X-Token") String token) {
        // 根据token信息获取username
        String username = JwtUtil.parseJWT(token).getId();
        if (username == null) {
            return R.error().message("未登陆");
        } else {
            // 获取用户的角色信息
            HashMap<String, Object> userRoleInfoMap = userService.getRoleInfo(username);
            return R.ok().data("data", userRoleInfoMap);
        }
    }

    @ApiOperation("获取所有用户角色信息")
    @RequestMapping(value = "getAllRoleInfo", method = RequestMethod.GET)
    public R getAllRoleInfo() {
        List<UserInfo> allUsers = userMapper.getAllUsers();
        return R.ok().data("data", allUsers);
    }

    @ApiOperation("获取所有资源/路由信息")
    @RequestMapping(value = "routes", method = RequestMethod.GET)
    public R getMenu() {
        List<MenuInfo> menus = menuMapper.getAllMenus();

        return R.ok().data("data", menus);
    }

    @ApiOperation("分配用户角色信息")
    @PostMapping("/assignUserRole")
    public R assignUserRole(String username, String roleName){

        List<User> userList = userService.query("username", username);
        if (userList.size() == 0) {
            return R.error().message("用户不存在");
        }

        List<Role> roleList = roleService.query("role_name", roleName);
        if(roleList.size() == 0) {
            return R.error().message("角色不存在");
        }

        // 分配用户角色
        Boolean result = userService.assignUserRole(userList.get(0), roleList.get(0));

        if (result) {
            return R.ok().message("分配角色成功");
        } else {
            return R.error().message("分配角色失败");
        }
    }
}
