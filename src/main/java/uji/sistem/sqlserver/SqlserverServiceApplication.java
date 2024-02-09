package uji.sistem.sqlserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import uji.sistem.sqlserver.model.Mahasiswa;
import uji.sistem.sqlserver.service.ReadFile;
import uji.sistem.sqlserver.service.SqlServerService;

import javax.sql.DataSource;

@SpringBootApplication
//@ComponentScan(basePackages = "uji.sistem.sqlserver.DatabaseConfig.java")
public class SqlserverServiceApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SqlserverServiceApplication.class, args);

//		Mahasiswa mahasiswa = context.getBean(Mahasiswa.class);
//
//		mahasiswa.setNim("6733004");
//
//		SqlServerService service = context.getBean(SqlServerService.class);
//		service.saveMahasiswa(mahasiswa);
//		for(Mahasiswa mahasiswa1 :service.getAllMahasiswa()){
//
//			System.out.println(mahasiswa1.getId_mhs());
//			System.out.println(mahasiswa1.getNama());
//			System.out.println(mahasiswa1.getNim());
//		}
		ReadFile file = context.getBean(ReadFile.class);

		file.readFile();
	}
}
