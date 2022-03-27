package com.open.design.responsibilitychain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 责任链处理对象
 * @author: liuxiaowei
 * @date: 2021年06月05日 10:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private RequestType type;
    private String name;
}
