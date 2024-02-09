package uji.sistem.sqlserver.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class ReadFile {

    public void readFile(){
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("D:\\Kuliah\\Semester 8\\Pengujian Sistem\\Data\\Data-1\\AA30ProcessLogLine_1afc1d43-3fe0-4b34-9ad9-6448127ef136.csv"));
            while((line=br.readLine()) != null){
                String[] coloms = line.split(";");
                for (String colom : coloms){
                    System.out.println(colom);
                }
            }
            br.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
