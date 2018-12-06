package com.hccnnet.salarySys.controller;

import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.service.IFileUploadService;
import com.hccnnet.salarySys.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by trcay on 2018/12/6.
 * 上传文件控制器
 */
@Controller
@RequestMapping(value = "/salarysys")
public class UploadController {

    @Autowired
    IFileUploadService FileUploadService;

    /**
     * 调用文件上传服务上传文件
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

        //1.上传文件到本地

        //2.读取excel并插入数据库
        //测试读取excel数据
        ReadExcel readExcel = new ReadExcel();
        List<Employees> employeesList = readExcel.getExcelInfo(file);
        System.out.println(employeesList.get(0).getEpName() + "=====" + employeesList.get(0).getEpGender() + "======" + employeesList.get(0).getDepartment()+ "======" + employeesList.get(0).getPhone());

        return FileUploadService.saveFile(file);
    }

}


