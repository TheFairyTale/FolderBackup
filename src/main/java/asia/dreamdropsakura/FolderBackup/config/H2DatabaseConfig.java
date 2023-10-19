package asia.dreamdropsakura.FolderBackup.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * H2嵌入式数据库配置
 *
 * @author TheFairyTale
 * @since 2023-10-19
 */
@Data
@Configuration
public class H2DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}
