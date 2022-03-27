package com.open.design.factory.simplefactory.tip001;

/**
 * @ClassName: PayFactory
 * @Description: 简单工厂-pay
 * @author: liuxiaowei
 * @date: 2021/6/5 10:11
*/
public class PayFactory {

    public static IPay createPay(String payType) {
        if (PayTypeEnum.ALI_PAY.getCode().equals(payType)) {
            return new ALiPay();
        }

        if (PayTypeEnum.WE_CHAT_PAY.getCode().equals(payType)) {
            return new WeChatPay();
        }

        if (PayTypeEnum.UNION_PAY.getCode().equals(payType)) {
            return new UnionPay();
        }

        return null;
    }

}
