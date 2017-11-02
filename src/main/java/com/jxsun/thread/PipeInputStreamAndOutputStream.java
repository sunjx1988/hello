package com.jxsun.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2017/11/2.
 */
public class PipeInputStreamAndOutputStream {

    class Inputer{

        private PipedInputStream input;

        Inputer(PipedInputStream input){
            this.input = input;
        }

        void input(){
            try {
                System.out.println("input start...");

                byte[] buffer = new byte[1024];
                int len = input.read(buffer);
                while (true){
                    if (len != -1) {
                        System.out.println(new String(buffer));
                        len = input.read(buffer);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("input end...");
            }
        }
    }

    class Outputer{

        private PipedOutputStream output;

        Outputer(PipedOutputStream output){
            this.output = output;
        }

        void output(){
            try {
                System.out.println("output start...");
                for (int i = 0;  ; i++) {
                    output.write((i + "\n").getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PipeInputStreamAndOutputStream programer = new PipeInputStreamAndOutputStream();

        try {
            PipedInputStream input = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();
            input.connect(out);
            Inputer inputer = programer.new Inputer(input);
            Outputer outputer = programer.new Outputer(out);

            new Thread(() -> {
                inputer.input();
            }).start();

            new Thread(() -> {
                outputer.output();
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
