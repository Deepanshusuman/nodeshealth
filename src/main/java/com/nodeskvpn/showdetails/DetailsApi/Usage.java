package com.nodeskvpn.showdetails.DetailsApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Usage {
    public String cpu;
    public String speed;

    public String getSpeed() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/root/bash/speedtest.sh");
        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            return String.valueOf(output);
        } else {
            return "0";
        }
    }

    public String getCpu() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // -- Linux --
        // Run a shell command
        // processBuilder.command("bash", "-c", "ls /home/mkyong/");

        // Run a shell script
        processBuilder.command("/root/bash/cpu.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

        // Run a bat file
        //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            return String.valueOf(output);
            //System.exit(0);
        } else {
            return "0";
        }
    }
}

