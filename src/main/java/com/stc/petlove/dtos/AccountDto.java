package com.stc.petlove.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 3/15/23
 * Time      : 9:40 AM
 * Filename  : AccountDto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String username;

    private String password;
}
