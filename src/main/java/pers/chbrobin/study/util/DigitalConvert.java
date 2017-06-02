//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pers.chbrobin.study.util;

import java.math.BigDecimal;

public class DigitalConvert {
    public DigitalConvert() {
    }

    public static Long wan2fen(Long value) {
        return value == null?null:Long.valueOf(value.longValue() * 1000000L);
    }

    public static Long yuan2fen(Long value) {
        return value == null?null:Long.valueOf(value.longValue() * 100L);
    }

    public static Long yuan2fen2(Double value) {
        return value == null?null:Long.valueOf(value.longValue() * 100L);
    }

    public static Long yuan2fen3(Double value) {
        if(value == null) {
            return null;
        } else {
            BigDecimal decimalValue = BigDecimal.valueOf(value.doubleValue());
            decimalValue = decimalValue.multiply(new BigDecimal(100));
            return Long.valueOf(decimalValue.longValue());
        }
    }

    public static Long yuan2fenBD(BigDecimal value) {
        return value == null?null:Long.valueOf(value.multiply(new BigDecimal(100)).longValue());
    }

    public static Long wan2fenBD(BigDecimal value) {
        return value == null?null:Long.valueOf(value.multiply(new BigDecimal(1000000)).longValue());
    }

    public static Long fen2wan(Long value) {
        return value == null?null:Long.valueOf(value.longValue() / 1000000L);
    }

    public static Long fen2yuan(Long value) {
        return value == null?null:Long.valueOf(value.longValue() / 100L);
    }

    public static Double fen2yuan(Long value, int precision) {
        return value == null?null:Double.valueOf(divide(value, Long.valueOf(100L), precision).doubleValue());
    }

    public static BigDecimal fen2yuan2(Long value, int precision) {
        return value == null?null:divide(value, Long.valueOf(100L), precision);
    }

    public static Double fen2wan(Long value, int precision) {
        return value == null?null:Double.valueOf(divide(value, Long.valueOf(1000000L), precision).doubleValue());
    }

    public static BigDecimal fen2wan2(Long value, int precision) {
        return value == null?null:divide(value, Long.valueOf(1000000L), precision);
    }

    public static BigDecimal divide(Long v1, Long v2, int precision) {
        if(null == v1) {
            return BigDecimal.valueOf(0L);
        } else if(null == v2) {
            return null;
        } else {
            BigDecimal fen = new BigDecimal(v1.longValue());
            BigDecimal wan = new BigDecimal(v2.longValue());
            fen = fen.setScale(precision, 4);
            wan = wan.setScale(precision, 4);
            return fen.divide(wan, precision, 4);
        }
    }

    public static BigDecimal multiply(BigDecimal b1, BigDecimal b2, int precision) {
        BigDecimal result = b1.multiply(b2);
        return result.divide(new BigDecimal(1L), precision, 4);
    }

    public static BigDecimal formatAfterPoint(BigDecimal b1, int precision) {
        return b1.divide(new BigDecimal(1L), precision, 4);
    }

    public static void main(String[] args) {
        yuan2fen3(Double.valueOf(0.06D));
    }
}
