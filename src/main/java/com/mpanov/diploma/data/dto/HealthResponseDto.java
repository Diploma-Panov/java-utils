package com.mpanov.diploma.data.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.mpanov.diploma.data.HealthStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HealthResponseDto {
    private HealthStatus status;

    public static HealthResponseDto up() {
        return new HealthResponseDto(HealthStatus.UP);
    }

    public static HealthResponseDto down() {
        return new HealthResponseDto(HealthStatus.DOWN);
    }

    private HealthResponseDto(HealthStatus status) {
        this.status = status;
    }
}
