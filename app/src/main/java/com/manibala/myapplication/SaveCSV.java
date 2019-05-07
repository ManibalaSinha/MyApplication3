package com.manibala.myapplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveCSV {
    File file;
    public SaveCSV(File file){
        this.file = file;
    }
    //pass List of string arrays into save() method
    public void save(List<String[]> list){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Unable to create File " + e);
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            for(int i = 0; i < list.size(); i++){
                String[] row = list.get(i);
                for(int j = 0; j < row.length; j++)
                {
                    writer.write(row[j]);
                    if(j != (row.length - 1)){
                        writer.write(',');
                    }
                    else{
                        writer.write("\\n");
                    }
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to File " + e);
        }
    }
}
