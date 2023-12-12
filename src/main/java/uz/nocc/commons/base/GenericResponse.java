package uz.nocc.commons.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Getter
@Setter
public class GenericResponse<T> {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("result")
    private GenericResult<T> result;

    public GenericResponse(Boolean success, Integer code, UUID audit, String message, T data) {
        this.success = success;
        this.result = new GenericResult<>(
                code,
                audit,
                message,
                data
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(UUID audit, T data) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, 40000, audit, "Success", data)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(Integer code, UUID audit) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, code, audit, "Success", null)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(Integer code, UUID audit, String message) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, code, audit, message, null)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(Integer code, UUID audit, String message, T data) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, code, audit, message, data)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error(Integer code, UUID audit) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.FALSE, code, audit, "Unknown Error", null)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error(Integer code, UUID audit, String message) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.FALSE, code, audit, message, null)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error(Integer code, UUID audit, String message, T data) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.FALSE, code, audit, message, data)
        );
    }
}
