package uz.nocc.commons.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * |      code     | message       |    action  |
 * |—————+————+————|
 * | 10000 - 19999 |       ✅       |     ✅     |
 * | 20000 - 29999 |       ✅       |     ❌     |
 * | 30000 - 39999 |       ❌       |     ✅     |
 * | 40000 - 49999 |       ❌       |     ❌     |
 */
public class GenericResult<T> {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("audit")
    private UUID audit;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;
}
