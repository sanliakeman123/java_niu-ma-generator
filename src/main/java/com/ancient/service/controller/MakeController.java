package com.ancient.service.controller;

import com.ancient.service.MakeService;
import com.common.util.FileUtil;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/make")
public class MakeController {

    @Resource
    HttpServletResponse response;
    @Resource
    MakeService makeService;

    @GetMapping("file")
    @ResponseBody
    public void file(@RequestParam String sourceUuid, @RequestParam String templateUuid ){
        try{
            String zipname = makeService.makeFiles(sourceUuid, templateUuid);
            if(zipname != null){
                download(zipname);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("dictFile")
    @ResponseBody
    public void dictFile(@RequestParam String sourceUuid, @RequestParam String templateUuid ){
        try{
            String zipname = makeService.makeDictFile(sourceUuid, templateUuid);
            if(zipname != null){
                download(zipname);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("joinFile")
    @ResponseBody
    public void joinFile(@RequestParam String sourceUuid, @RequestParam String templateUuid ){
        try{
            String zipname = makeService.makeJoinFile(sourceUuid, templateUuid);
            if(zipname != null){
                download(zipname);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void download(String zipname) throws IOException {
        File file = new File(zipname);
        String fileName = file.getName();
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        response.setContentLength((int)file.length());
        response.setHeader("Content-Disposition","attachment;fileName="+fileName);
        //??????????????????????????????????????????????????????Content-Disposition?????????????????????????????????
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        byte[] bytes = FileCopyUtils.copyToByteArray(file);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        FileUtil.deleteFile(file);
    }


}
