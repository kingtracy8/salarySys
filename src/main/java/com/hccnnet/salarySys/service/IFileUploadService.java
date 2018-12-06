package com.hccnnet.salarySys.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by trcay on 2018/12/6.
 */
public interface IFileUploadService {

    public String saveFile(MultipartFile file);

}
