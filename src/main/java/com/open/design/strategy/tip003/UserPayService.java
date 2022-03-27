package com.open.design.strategy.tip003;

import java.math.BigDecimal;

public interface UserPayService {

    BigDecimal quote(BigDecimal orderPrice);

    BigDecimal calPrice(BigDecimal orderPrice, String vipType);
}
