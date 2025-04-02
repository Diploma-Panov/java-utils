package com.mpanov.diploma.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

import static com.mpanov.diploma.data.MemberPermission.*;
import static java.util.Set.of;

@Getter
@AllArgsConstructor
public enum MemberRole {
    ORGANIZATION_OWNER(of(MemberRoleScope.URL_SHORTENER), EnumSet.allOf(MemberPermission.class)),
    ORGANIZATION_ADMIN(of(MemberRoleScope.URL_SHORTENER), EnumSet.of(ADMIN_ACCESS, MANAGE_URLS, INVITE_MEMBERS, MANAGE_MEMBERS, MANAGE_ORGANIZATION, BASIC_VIEW)),
    ORGANIZATION_MEMBERS_MANAGER(of(MemberRoleScope.URL_SHORTENER), EnumSet.of(BASIC_VIEW, MANAGE_MEMBERS, INVITE_MEMBERS)),
    ORGANIZATION_MANAGER(of(MemberRoleScope.URL_SHORTENER), EnumSet.of(BASIC_VIEW, MANAGE_ORGANIZATION)),
    ORGANIZATION_MEMBER(of(MemberRoleScope.URL_SHORTENER), EnumSet.of(BASIC_VIEW)),
    ORGANIZATION_URLS_MANAGER(of(MemberRoleScope.URL_SHORTENER), EnumSet.of(BASIC_VIEW, MANAGE_URLS));


    private final Set<MemberRoleScope> scopes;

    private final Set<MemberPermission> permissions;
}
