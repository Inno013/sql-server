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

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        if(service.cekCsvFormat(file)){
            String respon = service.prosesDanSaveData(file);
            if(respon.contains("Masukan file")){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                        .body(respon);
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(respon);
        }
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Tolong unggah file CSV");
    }
}
