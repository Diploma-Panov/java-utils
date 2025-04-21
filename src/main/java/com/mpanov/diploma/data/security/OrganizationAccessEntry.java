package com.mpanov.diploma.data.security;

import com.mpanov.diploma.data.MemberRole;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrganizationAccessEntry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long organizationId;

    @EqualsAndHashCode.Include
    private String slug;

    private Long[] allowedUrls;

    private Boolean allowedAllUrls;

    @Builder.Default
    private Set<MemberRole> roles = new HashSet<>();

}
