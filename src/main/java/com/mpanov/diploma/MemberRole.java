package com.mpanov.diploma;

import lombok.AllArgsConstructor;

import java.util.Set;

import static com.mpanov.diploma.MemberPermission.ORGANIZATION_FULL_ACCESS;
import static java.util.Set.of;

@AllArgsConstructor
public enum MemberRole {
    ORGANIZATION_OWNER(of(MemberRoleScope.URL_SHORTENER), of(ORGANIZATION_FULL_ACCESS));

    private final Set<MemberRoleScope> scopes;

    private final Set<MemberPermission> permissions;
}
