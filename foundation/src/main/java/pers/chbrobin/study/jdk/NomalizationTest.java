package pers.chbrobin.study.jdk;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenhuibin on 2017/6/25 0025.
 * 应用系统中经常对字符串会进行各种规则的验证，
 * 不过由于字符串信息在java6中是基于unicode的4.0版本的，
 * unicode的规范化格式有几种，每种的处理方式有些不一样。
 *  NFC
 * Unicode 规范化格式 C。如果未指定 normalization-type，那么会执行 Unicode 规范化。
 * NFD
 * Unicode 规范化格式 D。
 * NFKC
 * Unicode 规范化格式 KC。
 * NFKD
 * Unicode 规范化格式 KD。
 * 而java7则是unicode的6.0.0版本
 */
public class NomalizationTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 如果我们对输入字符串先进行验证，
     * 再规范化，Normalizer.normalize将unicode的文本转成等价的规范化格式内容，
     * 下面这个用Pattern.compile("[<>]")验证不通过，
     */
    public static void test1() {
        // String s may be user controllable
        // \uFE64 is normalized to < and \uFE65 is normalized to > using NFKC
        String s = "\uFE64" + "script" + "\uFE65";
        // Validate
        Pattern pattern = Pattern.compile("[<>]"); // Check for angle brackets
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // Found black listed tag
            throw new IllegalStateException();
        } else {
            // . . .
        }
        // Normalize
        s = Normalizer.normalize(s, Normalizer.Form.NFKC);
    }
    /**
     * 如果对输入字符串先进行规范化在进行验证，
     * 使用Pattern.compile("[<>]")验证就能正确判断出来，
     * 抛出IllegalStateException异常，正确过滤有问题的输入文本，
     */
    public static void test2() {
        String s = "\uFE64" + "script" + "\uFE65";
        // Normalize
        s = Normalizer.normalize(s, Normalizer.Form.NFKC);
        // Validate
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // Found black listed tag
            throw new IllegalStateException();
        } else {
            System.out.println("NomalizationTest ok");
        }
    }
}