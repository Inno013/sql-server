package uji.sistem.sqlserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import uji.sistem.sqlserver.model.ProsesLogLine;
import uji.sistem.sqlserver.service.File;
import uji.sistem.sqlserver.service.SqlServerService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = "uji.sistem.sqlserver.DatabaseConfig.java")
public class SqlserverServiceApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SqlserverServiceApplication.class, args);

		ProsesLogLine logLine = context.getBean(ProsesLogLine.class);
//		logLine.set
		File file = context.getBean(File.class);

		List<ProsesLogLine> logLines = file.ubahKeProsesLogLine(file.readFile("AA30ProcessLogLine_1afc1d43-3fe0-4b34-9ad9-6448127ef136.csv"));
//		System.out.println(file.readFile("AA30ProcessLogLine_1afc1d43-3fe0-4b34-9ad9-6448127ef136.csv"));
//		System.out.println(logLines);

		SqlServerService service = context.getBean(SqlServerService.class);
		int i = 0;
		for(ProsesLogLine log : logLines){
			service.saveProsesLogLine(log);
			if(i == 4){
				break;
			}
			i++;
		}
	}
}
