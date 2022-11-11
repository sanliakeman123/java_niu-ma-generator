package com.common.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    /**
     * 删除文件或者目录
     *
     * @param sourceFile 原文件 / 目录
     * @date 2022/6/28 20:37
     **/
    public static void deleteFile(File sourceFile) {
        // 判断参数
        if (sourceFile == null) {
            return;
        }
        // 判断是否是目录
        if (sourceFile.isDirectory()) {
            File[] childrenFile = sourceFile.listFiles();
            if (childrenFile != null && childrenFile.length > 0) {
                for (File childFile : childrenFile) {
                    // 删除子级 文件 / 目录
                    deleteFile(childFile);
                }
            }
        }
        // 删除 文件 / 目录 本身，不要用deleteOnExit()方法，不然无法删除目录
        sourceFile.delete();
    }

    public static void filetozip(String filepath,String zipname) throws IOException {
        File file=new File(filepath);
        OutputStream outputStream=new FileOutputStream(zipname);
        ZipOutputStream zipout=new ZipOutputStream(outputStream);
        //递归函数  三个参数分别代表 1:当前zipout流 2:当前文件/文件夹 3:在zip下的path
        dozip(zipout,file,"");
        zipout.finish();
        zipout.close();
        outputStream.close();
    }
    private static void dozip(ZipOutputStream zipout, File file, String addpath) throws IOException {
        if(file.isDirectory())//如果是个文件夹
        {
            File f[]=file.listFiles();
            for(int i=0;i<f.length;i++)
            {
                //如果是个文件夹 后面要加“/”因为它会遍历下层
                if(f[i].isDirectory()) {
                    dozip(zipout, f[i], addpath+f[i].getName()+"/");
                }//如果是文件，执行dozip下一次判断它不是文件夹就会进行压缩
                else {
                    dozip(zipout, f[i], addpath+f[i].getName());
                }
            }
        }
        else//不是文件夹，是文件
        {
            InputStream input;
            BufferedInputStream buff;
            //初始为"",意味不找下级就是("xxx.doc")，如果不是顶级目录层就("xx/yy/x.doc")
            zipout.putNextEntry(new ZipEntry(file.getName()));
            input=new FileInputStream(file);
            buff=new BufferedInputStream(input);
            byte b[]=new byte[1024];
            int a=0;
            while((a=buff.read(b))!=-1)
            {
                zipout.write(b,0, a);
            }
            buff.close();
            input.close();
        }

    }
}
