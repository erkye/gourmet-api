package com.gourmetapi.controller;

import cn.hutool.core.date.DateUtil;
import com.gourmetapi.exception.ApiException;
import com.gourmetapi.model.entity.FileUploadRecordEntity;
import com.gourmetapi.model.enums.EnumFileUploadStatus;
import com.gourmetapi.model.vo.MyUserDetails;
import com.gourmetapi.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Objects;
import java.util.UUID;

/**
 * @author none
 * @date 2020-10-23 - 15:30
 *
 * 文件相关的控制器层
 */
@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImageController {

    @Value("${user.filepath}")
    private String filePath;

    @Value("${server.port}")
    private String port;

    @Autowired
    private FileUploadService fileUploadService;

    /** 拼接URL前缀部分 */
    private final String URL_PREFIX = "http://";
    /** 拼接URL后缀部分 */
    private final String URL_SUFFIX = "/api/images/";


    /**
     * 上传图片接口
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = "multipart/form-data")
    public String upload(@RequestPart("file")MultipartFile multipartFile){
        MyUserDetails details = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        UUID uuid = UUID.randomUUID();
        String originalFileName = multipartFile.getOriginalFilename();
        String fileSuffix = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf('.'));
        long fileSize = multipartFile.getSize();
        String freshFilePath = filePath + uuid + fileSuffix;
        // 文件上传记录
        FileUploadRecordEntity record = fileUploadService.insertOne(FileUploadRecordEntity.builder()
                .userId(details.getUserEntity().getId())
                .originFileName(originalFileName)
                .fileSize(fileSize)
                .fileType(fileSuffix)
                .freshFileName(uuid.toString())
                .freshFilePath(freshFilePath)
                .status(EnumFileUploadStatus.UPLOADING.getCode())
                .createTime(DateUtil.date())
                .updateTime(DateUtil.date())
                .build());

        File file = new File(freshFilePath);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            // 修改状态为失败
            fileUploadService.updateStatus(record.getId(), EnumFileUploadStatus.FAIL.getCode());
            throw new ApiException("文件上传失败！");
        }
        String url = URL_PREFIX + getHostIp() + ":" + this.port + URL_SUFFIX + uuid+fileSuffix;
        record.setStatus(EnumFileUploadStatus.SUCCESS.getCode());
        record.setUrl(url);
        fileUploadService.updateOne(record);
        return url;
    }


    /**
     * 获取运行机器ip地址（非局域网）
     * @return
     */
    private static String getHostIp(){
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = addresses.nextElement();
                    if (ip instanceof Inet4Address
                            && !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                            && !ip.getHostAddress().contains(":")){
                        log.info("本机的IP = \" + ip.getHostAddress()");
                        return ip.getHostAddress();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
