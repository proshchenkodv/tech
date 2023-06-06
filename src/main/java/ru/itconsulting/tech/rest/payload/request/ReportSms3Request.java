package ru.itconsulting.tech.rest.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Intellij IDEA
 * User: DV_PROSCCHENKO
 * Date: 17.05.2023
 * Time: 16:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportSms3Request implements Serializable {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(example = "2023-05-03T00:00:00")
    private LocalDateTime day;
    private Integer routeName;
}
