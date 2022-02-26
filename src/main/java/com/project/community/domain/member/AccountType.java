package com.project.community.domain.member;

public enum AccountType {
    LESSOR("임대인"), REALTOR("공인 중개사"), LESSEE("임차인");
    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
