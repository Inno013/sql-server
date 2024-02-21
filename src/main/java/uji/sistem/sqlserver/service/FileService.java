package uji.sistem.sqlserver.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uji.sistem.sqlserver.model.ProsesLogLine;
import uji.sistem.sqlserver.model.ProsesLogTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private SqlServerService service;

    public List<MultipartFile> cekCsvFormat(List<MultipartFile> files){
        List<MultipartFile> fileList = new ArrayList<>();
         for(MultipartFile file : files){
            String type = "text/csv";
            if(type.equals(file.getContentType())){
                fileList.add(file);
            }
        }
        return fileList;
    }

    public void prosesDanSaveData(MultipartFile file){
        try{
            if(file.getOriginalFilename().contains("ProcessLogLine")){
                List<ProsesLogLine> logLines = csvKeLogLines(file.getInputStream());
                service.saveProsesLogLine(logLines);
            }else if(file.getOriginalFilename().contains("ProcessLogTable")){
                List<ProsesLogTable> logTables = csvKeLogTables(file.getInputStream());
                service.saveProsesLogTable(logTables);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<ProsesLogLine> csvKeLogLines(InputStream data) throws IOException {
        List<ProsesLogLine> result;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
        ) {
            List<CSVRecord> records = csvParser.getRecords();
            List<ProsesLogLine> logLines = new ArrayList<>();
            for (CSVRecord record : records) {
                ProsesLogLine logLine = new ProsesLogLine(
                        record.get("CMPNYCD"),
                        record.get("RCVNO"),
                        record.get("RX_ARRANGEMENT_NUMBER"),
                        Integer.parseInt(record.get("PROCESS_LOG_COUNT")),
                        record.get("LENS_RL_TYPE"),
                        Integer.parseInt(record.get("PREVIOUS_PROCESS_NUMBER")),
                        Integer.parseInt(record.get("PREVIOUS_SUBPROCESS_NUMBER")),
                        Integer.parseInt(record.get("CURRENT_PROCESS_NUMBER")),
                        Integer.parseInt(record.get("CURRENT_SUBPROCESS_NUMBER")),
                        record.get("DIP_LOT_NUMBER"),
                        record.get("COAT_LOT_NUMBER"),
                        record.get("BREAKAGE_REASON_NUMBER"),
                        record.get("BREAKAGE_RESPONSIBLE_PROCESS_NUMBER"),
                        record.get("PROCESS_FLAG_1"),
                        record.get("PROCESS_FLAG_2"),
                        record.get("PROCESS_FLAG_3"),
                        record.get("PROCESS_FLAG_4"),
                        record.get("PROCESS_FLAG_5"),
                        record.get("PROCESS_FLAG_6"),
                        record.get("PROCESS_FLAG_7"),
                        record.get("PROCESS_FLAG_8"),
                        record.get("PROCESS_FLAG_9"),
                        record.get("PROCESS_FLAG_10"),
                        record.get("PROCESS_FLAG_11"),
                        record.get("PROCESS_FLAG_12"),
                        record.get("PROCESS_FLAG_13"),
                        record.get("PROCESS_FLAG_14"),
                        record.get("PROCESS_FLAG_15"),
                        record.get("PROCESS_FLAG_16"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_1"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_2"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_3"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_4"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_5"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_6"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_7"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_8"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_9"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_10"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_11"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_12"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_13"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_14"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_15"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_16"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_17"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_18"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_19"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_20"),
                        record.get("MATERIAL_TYPE"),
                        record.get("MATERIAL_F_LENS_CODE"),
                        record.get("MATERIAL_F_COLOR_COAT_CODE"),
                        record.get("MATERIAL_F_LENS_NAME"),
                        record.get("MATERIAL_F_LENS_COLOR"),
                        record.get("MATERIAL_F_LENS_COAT"),
                        record.get("MATERIAL_F_LENS_CYLINDER_TYPE"),
                        record.get("MATERIAL_F_LENS_SPHERE"),
                        record.get("MATERIAL_F_LENS_CYLINDER"),
                        record.get("MATERIAL_F_LENS_AXIS"),
                        record.get("MATERIAL_F_LENS_ADDITION"),
                        record.get("MATERIAL_F_LENS_DIAMETER"),
                        record.get("MATERIAL_F_OPC"),
                        record.get("MATERIAL_S_LENS_CODE"),
                        record.get("MATERIAL_S_LENS_NAME"),
                        record.get("MATERIAL_S_LENS_COLOR"),
                        record.get("MATERIAL_S_LENS_MAKER"),
                        record.get("MATERIAL_S_LENS_NOMINAL_BC"),
                        record.get("MATERIAL_S_LENS_DIAMETER"),
                        record.get("MATERIAL_S_LENS_THICKNESS_TYPE"),
                        record.get("MATERIAL_S_LENS_ADDITION"),
                        record.get("MATERIAL_S_OPC"),
                        record.get("MATERIAL_R_LENS_CODE"),
                        record.get("MATERIAL_R_COLOR_COAT_CODE"),
                        record.get("MATERIAL_R_LENS_NAME"),
                        record.get("MATERIAL_R_LENS_COLOR"),
                        record.get("MATERIAL_R_LENS_COAT"),
                        record.get("MATERIAL_R_LENS_CYLINDER_TYPE"),
                        record.get("MATERIAL_R_LENS_SPHERE"),
                        record.get("MATERIAL_R_LENS_CYLINDER"),
                        record.get("MATERIAL_R_LENS_AXIS"),
                        record.get("MATERIAL_R_LENS_ADDITION"),
                        record.get("MATERIAL_R_LENS_DIAMETER"),
                        LocalDateTime.parse(record.get("AMDDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")));

                logLines.add(logLine);
            }
            result = logLines;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public List<ProsesLogTable> csvKeLogTables(InputStream data) throws IOException{
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase().withTrim())
        ) {
            List<CSVRecord> records = csvParser.getRecords();
            List<ProsesLogTable> logTables = new ArrayList<>();
            for (CSVRecord record : records) {
                ProsesLogTable logTable = new ProsesLogTable(
                        record.get("Completed"),
                        record.get("CMPNYCD"),
                        record.get("RCVNO"),
                        record.get("RX_ARRANGEMENT_NUMBER"),
                        Integer.parseInt(record.get("PROCESS_LOG_COUNT")),
                        record.get("PASS_DATE"),
                        record.get("PASS_TIME"),
                        record.get("PRODUCTION_COMPANY_CODE"),
                        record.get("PRODUCTION_PLACE_CODE"),
                        Integer.parseInt(record.get("BREAKAGE_COUNT")),
                        record.get("BREAKAGE_ID"),
                        Integer.parseInt(record.get("TOTDETLINE")),
                        LocalDateTime.parse(record.get("AMDDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")));

                logTables.add(logTable);
            }
            return logTables;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
