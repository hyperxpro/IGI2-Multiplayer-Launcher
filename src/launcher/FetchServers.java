/*
IGI-2 Multiplayer Launcher

Copyright (c) 2018, Aayush Atharva

Permission is hereby granted, free of charge to any person obtaining a copy of this software and associated documentation files 
(the "Software"), to deal in the Software with restriction. A person can use, copy the Software without restriction. But if a person modify
the software, the person must push the code to the Software GitHub repository. If a person wants to publish or distribute the software,
the person must put this "Created By: Aayush Atharva" on About Section of the Software. And If a person want's to sell the software,
the person get permission from the owner of this Software. 


IGI-2 Multiplayer Launche
Owner: Aayush Atharva
Email: aayush@igi2.co.in
*/

package launcher;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static launcher.Main.lista;
import static launcher.Main.oldList;
import static launcher.Main.update;
import static launcher.Main.updateServerList;

public class FetchServers extends Thread {

    @Override
    public void run() {
        try {
            boolean var = false;
            Server pom = null;
            oldList = new ArrayList();
            update = 0;
            List<String> ipList;
            ipList = Web.getServerList();
            lista = new ArrayList();
            Server s = null;
            for (String ips : ipList) {
                var = false;
                if (!oldList.isEmpty()) {
                    for (Server el : oldList) {
                        if (el.ips.equals(ips)) {
                            pom = el;
                            var = true;
                            break;
                        }
                    }
                }

                if (!var) {
                    s = new Server(ips);
                } else {
                    s = new Server(pom);
                }

                s.start();

            }

            while (update < ipList.size()) {
                Thread.sleep(10L);
            }

            updateServerList();
            oldList = lista;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable To Fetch Server. Please Check Your Internet And Try Again\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 135", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
