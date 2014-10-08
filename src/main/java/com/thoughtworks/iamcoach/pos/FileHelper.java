package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static List get (String filename) throws IOException {

        List<String> list = new ArrayList<String>();
        String path = FileHelper.class.getClassLoader().getResource(filename).getPath();

        BufferedReader br = new BufferedReader(new FileReader(path));

        String str;
        while((str = br.readLine()) != null){
            list.add(str);
        }
        return list;
    }
}
