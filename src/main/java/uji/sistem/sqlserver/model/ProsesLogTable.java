package uji.sistem.sqlserver.model;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class ProsesLogTable {
    private Long id;
    private String completed;
    private String cmpnycd;
    private String rcvno;
    private String rxArrangementNumber;
    private Integer processLogCount;
    private String passDate;
    private String passTime;
    private String productionCompanyCode;
    private String productionPlaceCode;
    private Integer breakageCount;
    private String breakageId;
    private Integer totdetline;
    private java.sql.Timestamp amddate;
}