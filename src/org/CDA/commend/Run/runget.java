package org.CDA.commend.Run;

import org.CDA.commend.commendCheck;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class runget {

    static String web = "https://github.com/ltsAhMe/CDYpack/raw/main";

    public static void HelpShow(String[] args){
        System.out.println("you can use it to get Run in web or anyway");
        System.out.println("org.CDA.commend.Run.runget \"Name\" to get run");
        System.out.println("\"-webset\" can set get web");
        System.out.println("\"-file\" get file run");
        System.out.println("\"-uninstall\" del run");
    }
    public static void Runtime(String[] args) throws IOException {
        if (args.length>1){
            switch (args[1]) {
                case "-webset":
                    if (args.length<3){
                        System.out.println(web);
                    }else {
                        web = args[2];
                    }
                    break;
                case "-file":
                        File done1 = new File(args[2]);
                      copyFile(args[2],commendCheck.pathName+"/"+done1.getName());
                    commendCheck.setCommends();
                    break;
                case "-uninstall":
                    String Path = commendCheck.pathName+"/"+args[2]+".class";
                   runget.delFile(Path);
                    commendCheck.setCommends();
                   break;
                case "-update":
                    commendCheck.setCommends();
                    break;
                default:
                    download(args[1]);
                    commendCheck.setCommends();
                    break;
            }
        }
    }
    private static void copyFile(String source, String target) {
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);

        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("done");
            // 在此处添加其他操作，如果需要的话
        } catch (IOException e) {
            System.out.println("fuck" + e.getMessage());
            // 如果需要，可以在此处添加异常处理逻辑
        }
    }
     private static void delFile(String path){
        File file = new File(path);
        file.delete();
     }
    protected static void download(String name) {
        String fileName = name+".class";
        String url = web + "/"+ fileName;
        System.out.println("start download:"+name);
        System.out.println(url);
        downloadByNIO2(url,commendCheck.pathName,fileName);
    }

    public static void downloadByNIO2(String url, String saveDir, String fileName) {
        try (InputStream ins = new URL(url).openStream()) {
            Path target = Paths.get(saveDir, fileName);
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
