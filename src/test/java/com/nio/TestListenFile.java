package com.nio;

import java.nio.file.*;

public class TestListenFile {

    public static void main(String[] args) throws Exception {


        new Thread() {

            public void run() {

                try {

                    WatchService watchService = FileSystems.getDefault().newWatchService();
                    Paths.get("C:\\Users\\Administrator\\Desktop").

                            register(watchService,
                                    StandardWatchEventKinds.ENTRY_CREATE,
                                    StandardWatchEventKinds.ENTRY_DELETE,
                                    StandardWatchEventKinds.ENTRY_MODIFY);
                    while (true) {
                        WatchKey key = watchService.take();
                        for (WatchEvent<?> event : key.pollEvents()) {
                            System.out.println(event.context() + "发生了" + event.kind() + "事件");
                        }
                        if (!key.reset()) {
                            break;
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }

        }.start();

    }
}
