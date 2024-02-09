package uji.sistem.sqlserver.service;

import org.springframework.stereotype.Service;
import uji.sistem.sqlserver.model.ProsesLogLine;
import uji.sistem.sqlserver.model.ProsesLogTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class File {

    public ArrayList<String> readFile(String filename){
        ArrayList<String> list = new ArrayList<>();
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("D:\\Kuliah\\Semester 8\\Pengujian Sistem\\Data\\Data-1\\" + filename));
            int i = 0;
            while((line=br.readLine()) != null){
                String coloms = line;
                if(i != 0){
                    list.add(coloms);
                }
                i++;
            }
            br.close();
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return list;
        }
    }

    public List<ProsesLogLine> ubahKeProsesLogLines(ArrayList<String> data){
        List<ProsesLogLine> logLines = new ArrayList<>();
        for (String line: data){
            ProsesLogLine logLine  = new ProsesLogLine();

            String[] coloms = line.split(",");
            logLine.setCmpnycd(coloms[0]);
            logLine.setRcvno(coloms[1]);
            logLine.setRxArrangementNumber(coloms[2]);
            logLine.setProcessLogCount(Integer.parseInt(coloms[3]));
            logLine.setLensRlType(coloms[4]);
            logLine.setPreviousProcessNumber(Integer.parseInt(coloms[5]));
            logLine.setPreviousSubprocessNumber(Integer.parseInt(coloms[6]));
            logLine.setCurrentProcessNumber(Integer.parseInt(coloms[7]));
            logLine.setCurrentSubprocessNumber(Integer.parseInt(coloms[8]));
            logLine.setDipLotNumber(coloms[9]);
            logLine.setCoatLotNumber(coloms[10]);
            logLine.setBreakageReasonNumber(coloms[11]);
            logLine.setBreakageResponsibleProcessNumber(coloms[12]);
            logLine.setProcessFlag1(coloms[13]);
            logLine.setProcessFlag2(coloms[14]);
            logLine.setProcessFlag3(coloms[15]);
            logLine.setProcessFlag4(coloms[16]);
            logLine.setProcessFlag5(coloms[17]);
            logLine.setProcessFlag6(coloms[18]);
            logLine.setProcessFlag7(coloms[19]);
            logLine.setProcessFlag8(coloms[20]);
            logLine.setProcessFlag9(coloms[21]);
            logLine.setProcessFlag10(coloms[22]);
            logLine.setProcessFlag11(coloms[23]);
            logLine.setProcessFlag12(coloms[24]);
            logLine.setProcessFlag13(coloms[25]);
            logLine.setProcessFlag14(coloms[26]);
            logLine.setProcessFlag15(coloms[27]);
            logLine.setProcessFlag16(coloms[28]);
            logLine.setAdditionalTreatmentType1(coloms[29]);
            logLine.setAdditionalTreatmentType2(coloms[30]);
            logLine.setAdditionalTreatmentType3(coloms[31]);
            logLine.setAdditionalTreatmentType4(coloms[32]);
            logLine.setAdditionalTreatmentType5(coloms[33]);
            logLine.setAdditionalTreatmentType6(coloms[34]);
            logLine.setAdditionalTreatmentType7(coloms[35]);
            logLine.setAdditionalTreatmentType8(coloms[36]);
            logLine.setAdditionalTreatmentType9(coloms[37]);
            logLine.setAdditionalTreatmentType10(coloms[38]);
            logLine.setAdditionalTreatmentType11(coloms[39]);
            logLine.setAdditionalTreatmentType12(coloms[40]);
            logLine.setAdditionalTreatmentType13(coloms[41]);
            logLine.setAdditionalTreatmentType14(coloms[42]);
            logLine.setAdditionalTreatmentType15(coloms[43]);
            logLine.setAdditionalTreatmentType16(coloms[44]);
            logLine.setAdditionalTreatmentType17(coloms[45]);
            logLine.setAdditionalTreatmentType18(coloms[46]);
            logLine.setAdditionalTreatmentType19(coloms[47]);
            logLine.setAdditionalTreatmentType20(coloms[48]);
            logLine.setMaterialType(coloms[49]);
            logLine.setMaterialFLensCode(coloms[50]);
            logLine.setMaterialFColorCoatCode(coloms[51]);
            logLine.setMaterialFLensName(coloms[52]);
            logLine.setMaterialFLensColor(coloms[53]);
            logLine.setMaterialFLensCoat(coloms[54]);
            logLine.setMaterialFLensCylinderType(coloms[55]);
            logLine.setMaterialFLensSphere(coloms[56]);
            logLine.setMaterialFLensCylinder(coloms[57]);
            logLine.setMaterialFLensAxis(coloms[58]);
            logLine.setMaterialFLensAddition(coloms[59]);
            logLine.setMaterialFLensDiameter(coloms[60]);
            logLine.setMaterialFOPC(coloms[61]);
            logLine.setMaterialSLensCode(coloms[62]);
            logLine.setMaterialSLensName(coloms[63]);
            logLine.setMaterialSLensColor(coloms[64]);
            logLine.setMaterialSLensMaker(coloms[65]);
            logLine.setMaterialSLensNominalBC(coloms[66]);
            logLine.setMaterialSLensDiameter(coloms[67]);
            logLine.setMaterialSLensThicknessType(coloms[68]);
            logLine.setMaterialSLensAddition(coloms[69]);
            logLine.setMaterialSOPC(coloms[70]);
            logLine.setMaterialRLensCode(coloms[71]);
            logLine.setMaterialRColorCoatCode(coloms[72]);
            logLine.setMaterialRLensName(coloms[73]);
            logLine.setMaterialRLensColor(coloms[74]);
            logLine.setMaterialRLensCoat(coloms[75]);
            logLine.setMaterialRLensCylinderType(coloms[76]);
            logLine.setMaterialRLensSphere(coloms[77]);
            logLine.setMaterialRLensCylinder(coloms[78]);
            logLine.setMaterialRLensAxis(coloms[79]);
            logLine.setMaterialRLensAddition(coloms[80]);
            logLine.setMaterialRLensDiameter(coloms[81]);
            logLine.setAmddate(LocalDateTime.parse(coloms[82], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")));

            logLines.add(logLine);
        }
        return logLines;
    }

    public List<ProsesLogTable> ubahKeProsesLogTables(ArrayList<String> data){
        List<ProsesLogTable> logTables = new ArrayList<>();
        for (String tables: data) {
            ProsesLogTable logTable = new ProsesLogTable();
        }
        return logTables;
    }

}
