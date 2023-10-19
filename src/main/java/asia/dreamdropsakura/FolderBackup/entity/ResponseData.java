package asia.dreamdropsakura.FolderBackup.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
public class ResponseData implements Serializable {

    private String data;

    private String detail;

    private Integer code;

    private ResponseData(String data, String detail, Integer code) {
        this.data = data;
        this.detail = detail;
        this.code = code;
    }

    public static ResponseData ok() {
        return new ResponseData(null, null, 200);
    }

    public static ResponseData ok(String data) {
        return new ResponseData(data, null, 200);
    }

    public static ResponseData ok(String data, String detail) {
        return new ResponseData(data, detail, 200);
    }

    public static ResponseData error(String detail) {
        return new ResponseData(null, detail, 500);
    }

    public static ResponseData error(String data, String detail) {
        return new ResponseData(data, detail, 500);
    }
}
