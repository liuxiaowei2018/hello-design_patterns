package com.open.design.strategy.example.login;

import lombok.Data;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 9:25
 */
@Data
public class LoginRequest {
    private LoginType loginType;
    private Long userId;
}
