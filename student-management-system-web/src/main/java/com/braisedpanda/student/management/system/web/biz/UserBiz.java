package com.braisedpanda.student.management.system.web.biz;

import com.alibaba.fastjson.JSONObject;

import com.braisedpanda.student.management.system.permission.model.po.UserRole;
import com.braisedpanda.student.management.system.permission.service.PermissionService;
import com.braisedpanda.student.management.system.permission.service.UserRoleService;
import com.braisedpanda.student.management.system.user.model.po.User;
import com.braisedpanda.student.management.system.user.service.UserService;
import com.braisedpanda.student.management.system.web.utils.JsonUtils;
import com.braisedpanda.student.management.system.web.utils.PageHelperUtils;
import com.braisedpanda.student.management.system.web.utils.ResultType;
import com.github.pagehelper.PageHelper;

import org.apache.dubbo.config.annotation.Reference;


import org.springframework.stereotype.Service;


import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserBiz {

    @Reference(version = "1.0.0")
    UserService userService;

    @Reference(version = "1.0.0")
    PermissionService permissionService;
    @Reference(version = "1.0.0")
    UserRoleService userRoleService;


    /**
     * 用户角色表（userrole）
     * 查找userrole表中数据，在前台进行展示
     * @param page
     * @param limit

     */
    public  String testtable(int page,int limit){

        int count = userService.countUser();
        PageHelper.startPage(page,limit);
        List<User> userList1 = userService.listUsers();

        for (User user:
                userList1) {
            List<UserRole> userRoleList = userRoleService.getUserRoleByUid(user.getUid());
            StringBuffer sb = new StringBuffer();
            //如果没有角色，追加【无角色】样式
            if(userRoleList ==null || userRoleList.size()==0){
//                user.setRoleList("无角色");

            }
            else {
                for (UserRole userRole :
                        userRoleList) {
                    sb.append("【");
                    sb.append(userRole.getRole());
                    sb.append("】");

                }
//                user.setRoleList(sb.toString());
            }



        }
        List resultList = PageHelperUtils.getResultList(userList1);
        String result =  JsonUtils.createResultJson(ResultType.SimpleResultType.SUCCESS,count,resultList).toJSONString();


        return result;

    }


    /**
     * 图片上传测试
     * @param file
     * @param request
     *
     */
    public String upload(MultipartFile file,HttpServletRequest request){

        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                String filepath = "D:\\StudentManagementSystem\\src\\main\\resources\\static\\images\\" + dateStr+"\\"+uuid+"." + prefix;


                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map2=new HashMap();
                Map<String,Object> map=new HashMap();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                map2.put("src","/images/"+ dateStr+"/"+uuid+"." + prefix);
                JSONObject json = new JSONObject(map);
                return json.toJSONString();
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap();
        map.put("code",1);
        map.put("msg","");

        JSONObject json = new JSONObject(map);

        return json.toJSONString();

    }





}
