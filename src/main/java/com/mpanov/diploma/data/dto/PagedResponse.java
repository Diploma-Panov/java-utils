package com.mpanov.diploma.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse {

    private Integer total;

    private Boolean hasMore;

    private Integer page;

    private Integer perPage;

}
