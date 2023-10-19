package asia.dreamdropsakura.FolderBackup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class FolderBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(FolderBackupApplication.class, args);
	}

}
