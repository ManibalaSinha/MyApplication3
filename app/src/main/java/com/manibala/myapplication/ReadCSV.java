package com.manibala.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCSV {
    InputStream in;
//file data into InputStream
    public ReadCSV(InputStream in){
        this.in = in;
    }
    public List<String[]> read(){
        List<String[]> results = new ArrayList<String[]>();
        //BufferedReader to grab data line by line as we iterate through it into InputStream
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String line;
            while((line = reader.readLine()) != null){
                //split incoming lines into string arrays
                String[] row = line.split(",");
                System.out.println(Arrays.toString(row));
                results.add(row);
            }
        }
        catch (IOException e){
            throw new RuntimeException("Error reading CSV File " + e);
        }
        finally{
            try {
                in.close();
            }
            catch (IOException e){
                throw new RuntimeException("Error closing inputstream " + e);
            }
        }

        return results;
    }
}
