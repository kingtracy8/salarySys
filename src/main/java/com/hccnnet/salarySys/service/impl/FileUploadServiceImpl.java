package com.hccnnet.salarySys.service.impl;

import com.hccnnet.salarySys.service.IFileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by trcay on 2018/12/6.
 * 文件上传、下载Service
 */
@Service
public class FileUploadServiceImpl implements IFileUploadService{
    @Override
    public String saveFile(MultipartFile file) {
        if (!file.isEmpty()) {

/*            String contextPath = request.getContextPath();//"/SpringMvcFileUpload"
            String servletPath = request.getServletPath();//"/gotoAction"
            String scheme = request.getScheme();//"http"*/


            String storePath= "G:\\uploadtest";//存放上传的文件路径

            String fileName = file.getOriginalFilename();

            File filepath = new File(storePath, fileName);

            if (!filepath.getParentFile().exists()) {

                filepath.getParentFile().mkdirs();//如果目录不存在，创建目录

            }

            try {
                file.transferTo(new File(storePath+ File.separator+fileName));//把文件写入目标文件地址

            } catch (Exception e) {

                e.printStackTrace();

                return "error";

            }

            return "success";//返回到成功页面

        }else {

            return "error";//返回到失败的页面
        }
    }
}
