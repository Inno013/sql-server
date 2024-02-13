package uji.sistem.sqlserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uji.sistem.sqlserver.service.FileService;

@RestController
@RequestMapping(value = "/api")
public class SqlServerController {
    @Autowired
    private FileService service;

    @PostMapping(value = "/logline")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        if(service.cekCsvFormat(file)){
            service.prosesDanSaveDataLine(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Upload File Sukses " + file.getOriginalFilename());
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Tolong unggah file CSV");
    }
}
