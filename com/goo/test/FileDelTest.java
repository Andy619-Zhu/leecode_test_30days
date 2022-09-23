package com.goo.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class FileDelTest {

    public static void main(String[] args) {
        //absolute file name with path
        File file = new File("E:/ztest/file.csv");
        if (file.delete()) {
            System.out.println("E:/ztest/file.csv File deleted");
        } else {
            System.out.println("File E:/ztest/file.csv doesn't exist");
        }

        String sTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH"));

        System.out.println(sTime);
        System.out.println(getDayAgoOrAfterString(-3));

        List<String> fileName = getFiles("E:/ztest/");
        for (String s : fileName) {
//            System.out.println(s);
//            System.out.println(s.matches("(.*)22-05-30(.*)"));
            if (s.matches("(.*)" + getDayAgoOrAfterString(-4) + "(.*)")) {
                File file1 = new File(s);
                if (file1.delete()) {
                    System.out.println(file1 + "： 删除成功");
                } else {
                    System.out.println(file1 + ": 不存在");
                }

            }
        }


//        //file name only
//        file = new File("file.txt");
//        if(file.delete()){
//            System.out.println("file.txt File deleted from Project root directory");
//        }else {
//            System.out.println("File file.txt doesn't exist in the project root directory");
//        }
//
//        //relative path
//        file = new File("temp/file.txt");
//        if(file.delete()){
//            System.out.println("temp/file.txt File deleted from Project root directory");
//        }else {
//            System.out.println("File temp/file.txt doesn't exist in the project root directory");
//        }
//
//        //delete empty directory
//        file = new File("temp");
//        if(file.delete()){
//            System.out.println("temp directory deleted from Project root directory");
//        }else {
//            System.out.println("temp directory doesn't exist or not empty in the project root directory");
//        }
//
//        //try to delete directory with files
//        file = new File("/Users/pankaj/project");
//        if(file.delete()){
//            System.out.println("/Users/pankaj/project directory deleted from Project root directory");
//        }else {
//            System.out.println("/Users/pankaj/project directory doesn't exist or not empty");
//        }
    }

    /**
     * @param num ﹣3 三天前 +3 三天后
     * @return
     */
    public static String getDayAgoOrAfterString(int num) {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        calendar1.add(Calendar.DATE, num);
        return sdf1.format(calendar1.getTime());
    }


    /**
     * 获取文件夹下的所有目录
     *
     * @param path 对应文件夹
     * @return 所有文件名称的list
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        assert tempList != null;
        for (File value : tempList) {
            if (value.isFile()) {
                files.add(value.toString());
            }
        }
        return files;
    }

}

