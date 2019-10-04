/**
 * 
 */
package com.huiyong.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huiyong.dao.AppInfoMapper;
import com.huiyong.model.AppInfo;

/**
 * @author gangpu
 *
 */
@RestController
public class AppController {
	@Autowired
	private AppInfoMapper appInfoDao;
	
    @Value("${pointservice.client.path}")
    private String clientFilePath;
    
    @RequestMapping(value = "/appClient", method = RequestMethod.GET)  
    public ResponseEntity<InputStreamResource> downloadFile()  
            throws IOException {  
        FileSystemResource file = new FileSystemResource(clientFilePath);  
        HttpHeaders headers = new HttpHeaders();  
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));  
        headers.add("Pragma", "no-cache");  
        headers.add("Expires", "0");  
  
        return ResponseEntity  
                .ok()  
                .headers(headers)  
                .contentLength(file.contentLength())  
                .contentType(MediaType.parseMediaType("application/octet-stream"))  
                .body(new InputStreamResource(file.getInputStream()));  
    }  
    
    @RequestMapping(value = "/appInfo", method = RequestMethod.GET)  
    public ResponseEntity<List<AppInfo>> getAppInfo()  {
    	return ResponseEntity.ok().body(appInfoDao.getAppInfo());			
    } 
}
