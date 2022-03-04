package com.project.community.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseEntity {

    private String createBy;
    private LocalDateTime createDate;
    private String updateBy;
    private LocalDateTime updateDate;
}
