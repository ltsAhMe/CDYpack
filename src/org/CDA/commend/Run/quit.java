package org.CDA.commend.Run;

import org.CDA.CDA;

public class quit {
    public static void HelpShow(String[] args){
        System.out.println("exit");
    }
    public static void Runtime(String[] args){
        if (args.length>1){
            if (args[1].equals("reboot")){
                CDA.CDAbreak();
                CDA.CDAstart();
                CDA cda = new CDA();
            }
        }else {
            System.exit(1);
        }
    }
}
