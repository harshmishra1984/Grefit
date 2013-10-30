package com.rimt.dataaccess.entities;

public enum RolesType {

    ROLE_SUPERUSER(4,"ROLE_SUPERUSER","Super User"),

    ROLE_ACCOUNT_ADMINISTRATOR(1,"ROLE_ACCOUNT_ADMINISTRATOR","Administrator"),

    ROLE_BUSINESS_ADMINISTRATOR (2, "ROLE_BUSINESS_ADMINISTRATOR","Business Administrator"),

    ROLE_LIST_MANAGER(3, "ROLE_LIST_MANAGER","List Manager");

    final int typeId;
    String name;
    String uiName;

    private RolesType(int typeId, String name,String uiName) {
        this.typeId = typeId;
        this.name = name;
        this.uiName = uiName;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }
    public String getUiName() {
        return uiName;
    }

    public String toString() {
        return uiName;
    }

    public static String getRoleName(int roleId) {

       for (RolesType role : RolesType.values()) {
           if (role.getTypeId() == roleId) {
               return role.getUiName();
           }
       }
       return null;
    }

    public static String getName(int roleId) {

       for (RolesType role : RolesType.values()) {
           if (role.getTypeId() == roleId) {
               return role.getName();
           }
       }
       return null;
    }
}