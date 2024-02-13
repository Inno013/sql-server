package uji.sistem.sqlserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import uji.sistem.sqlserver.model.ProsesLogLine;
import uji.sistem.sqlserver.model.ProsesLogTable;
import uji.sistem.sqlserver.service.FileService;
import uji.sistem.sqlserver.service.SqlServerService;

import java.util.List;

@SpringBootApplication
public class SqlserverServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SqlserverServiceApplication.class, args);
	}
}
