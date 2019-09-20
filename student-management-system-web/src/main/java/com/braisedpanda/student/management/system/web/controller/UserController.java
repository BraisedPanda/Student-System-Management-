package com.braisedpanda.student.management.system.web.controller;



import com.braisedpanda.student.management.system.user.model.po.User;
import com.braisedpanda.student.management.system.user.service.UserService;

import com.braisedpanda.student.management.system.web.biz.UserBiz;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;


    @Autowired
    UserBiz userBiz;


    //查找所有的用户
    @RequestMapping("/alluser")
    public ModelAndView allUser2(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.listUsers();

        modelAndView.addObject("useList",userList);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    //用户注册
    @RequestMapping("/regist")
    public String regist2(User user,Model model,String activeCode){

        if(activeCode ==null || activeCode.length()==0){
            user.setActiveCode("0");
        }
        //设置用户默认头像
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");
        userService.insertUser(user);

        model.addAttribute("user",user);

        return "redirect:/";
    }

    /**
     * 用户登录，使用shiro进行验证登录
     * @param username
     * @param password
     * @param session
     * 1、从SecurityUtils里边创建一个 subject
     * 2、在认证提交前准备 token（令牌）
     * 3、开始认证登录
     */
    @PostMapping("/login")
    public ModelAndView login2(String username, String password, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();


        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (IncorrectCredentialsException ice) {
            modelAndView.addObject("tips","*密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (LockedAccountException lae) {
            modelAndView.addObject("tips","*账户已锁定~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (ExcessiveAttemptsException eae) {
            modelAndView.addObject("tips","*用户名或密码错误次数过多~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (AuthenticationException ae) {
            modelAndView.addObject("tips","*用户名或密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        if (subject.isAuthenticated()) {
            User user = userService.selectUserByUsernameAndPasword(username,password);
            session.setAttribute("user",user);
            modelAndView.setViewName("menu/main");
            return modelAndView;
        } else {
            token.clear();
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }



    //删除用户
    @RequestMapping("/delete/{uid}")
    public String delete(@PathVariable("uid") String uid){
        User user = new User();
        user.setUid(Integer.parseInt(uid));
        userService.deleteUser(user);

        return "user/blank";
    }

    //修改用户信息(回显)

    @RequestMapping("edituser/{uid}")
    public ModelAndView getuser2(@PathVariable("uid") int uid){
        ModelAndView modelAndView = new ModelAndView();
        User user1 = new User();
        user1.setUid(uid);
        User user = userService.getUserById(user1);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }




    //编辑用户(后台编辑)
    //修改用户信息
    @RequestMapping("user_edit")
    public String user_edit(User user){


        userService.updateUserById(user);


        return "user/success";
    }




    //添加用户(layui弹出层)
    //新增用户（后台添加）
    @RequestMapping("/add_user")
    public String add_user2(User user){
        user.setImages("/images/2019-08-07/f8aa0870-e4ea-4170-9772-296204476267.jpg");

        userService.insertUser(user);


        return "user/success";


    }
    //退出登录
    @RequestMapping("/quite")
    public String quite(HttpSession session){
        session.removeAttribute("user");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        return "redirect:/";
    }


    //查询用户角色表
    @RequestMapping("user/table")
    public @ResponseBody String testtable2(int page,int limit){

       String result = userBiz.testtable(page,limit);

        return result;

    }



    @RequestMapping("/userlist2")
    public  String userlist2(){


        return "user/userlist2";
    }

    //图片上传测试
    @ResponseBody
    @RequestMapping("upload")
    public String upload2(MultipartFile file,HttpServletRequest request){

        String result = userBiz.upload(file,request);

        return result;

    }


    //修改用户信息(回显)

    @RequestMapping("userinfo")
    public ModelAndView userinfo2(HttpSession session){
        User user1 = (User)session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(user1);

        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/userlist2");
        return modelAndView;
    }


    //跳转到注册界面
    @RequestMapping("toregist")
    public String toregist(){
        return "user/regist";
    }

    //跳转到登录界面
    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

    //主页内容
    @RequestMapping("index")
    public String index(){
        return "menu/main";
    }


    //跳转到登录界面
//    @RequestMapping("login")
//    public String toologin(){
//        return "redirect:/";
//    }


    //跳转到左侧菜单栏
    @RequestMapping("toleft")
    public String toleft(){
        return "menu/left";
    }



}
