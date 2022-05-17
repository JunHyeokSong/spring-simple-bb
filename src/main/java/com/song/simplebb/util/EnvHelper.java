package com.song.simplebb.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.System.exit;

public class EnvHelper {
    private final static EnvHelper instance = new EnvHelper();
    private static HashMap<String, String> env;
    private EnvHelper() {
        env = new HashMap<String, String>();

        try (BufferedReader br = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splt = line.split("=");
                env.put(splt[0], splt[1]);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot found .env file...");
            exit(-1);
        }
        catch (IOException e) {
            System.out.println("IO Exception");
            exit(-1);
        }
    }
    public static EnvHelper getInstance() {
        return instance;
    }
    public static HashMap<String, String> getEnv() { return env; }
}
