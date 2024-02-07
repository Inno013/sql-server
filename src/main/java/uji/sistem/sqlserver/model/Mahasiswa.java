package uji.sistem.sqlserver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Mahasiswa {
    @Getter
    @Setter
    private Long id_mhs;
    @Getter
    @Setter
    private String nama;
    @Getter
    @Setter
    private String nim;
}
