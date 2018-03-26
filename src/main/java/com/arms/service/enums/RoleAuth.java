package com.arms.service.enums;

/**
 * @author liuchen
 * @since 2017/12/19
 */
public enum RoleAuth {

    ROLE_ADMIN("ROLE_ADMIN"),

    ROLE_PRODUCT("ROLE_PRODUCT"),

    ROLE_USER("ROLE_USER");

    private String value;

    private RoleAuth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static RoleAuth getRoleAuth(String value) {
        for (RoleAuth roleAuth : RoleAuth.values()) {
            if (roleAuth.getValue().equals(value)) {
                return roleAuth;
            }
        }
        return null;
    }
}
