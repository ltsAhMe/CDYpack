package org.CDA.commend.Run;

import org.CDA.commend.commendCheck;

public class help {
    public static void Runtime(String[] args){
       if (args.length<2){
           System.out.print("Help:");
           System.out.println("look source or org.CDA.commend.Run.help commend,org.CDA.commend.Run.help list");
           System.out.print("dev:");
           System.out.println("god");
       }else {
           if (args[1].equals("list")){
               for (Class<?> clazz : commendCheck.Commends) {
                   System.out.println(clazz.getName().substring(commendCheck.packName.length()+1,clazz.getName().length()));
               }
           }else {
               commendCheck.toRun("HelpShow", args[1]);
           }
       }
    }
    public static void HelpShow(String[] args){
        System.out.println("good idea");
    }
}
