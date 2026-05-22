package com.erp.app.global.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntity {
	private LocalDateTime firstRegDate;  // 최초등록일
    private String firstRegUserId;       // 최초등록자ID
    private LocalDateTime lastChgDate;   // 최종변경일
    private String lastChgUserId;        // 최종변경자ID
}
