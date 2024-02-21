package uji.sistem.sqlserver.service;


import org.springframework.stereotype.Service;
import uji.sistem.sqlserver.model.ProsesLogLine;
import uji.sistem.sqlserver.model.ProsesLogTable;
import uji.sistem.sqlserver.repository.ProsesLogLineRepository;
import uji.sistem.sqlserver.repository.ProsesLogTableRepository;

import java.util.List;

@Service
public class SqlServerService {
    private final ProsesLogLineRepository prosesLogLineRepository;
    private final ProsesLogTableRepository prosesLogTableRepository;

    public SqlServerService(ProsesLogLineRepository prosesLogLineRepository, ProsesLogTableRepository prosesLogTableRepository) {
        this.prosesLogLineRepository = prosesLogLineRepository;
        this.prosesLogTableRepository = prosesLogTableRepository;
    }

    public List<ProsesLogLine> getAllProsesLogLine() {
        return prosesLogLineRepository.getAllProsesLogLine() ;
    }

    public void saveProsesLogLine(List<ProsesLogLine> proseslogline) {
        for(ProsesLogLine logLine : proseslogline){
            prosesLogLineRepository.saveProsesLogLine(logLine);
        }
    }

    public List<ProsesLogTable> getAllProsesLogTable() {
        return prosesLogTableRepository.getAllProsesLogTable() ;
    }

    public void saveProsesLogTable(List<ProsesLogTable> prosesLogTables) {
        for (ProsesLogTable logTable : prosesLogTables){
            prosesLogTableRepository.saveProsesLogTable(logTable);
        }
    }

}