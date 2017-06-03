package pers.chbrobin.study.expression;

import net.sf.json.JSONObject;
import pers.chbrobin.study.util.DigitalConvert;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/2 0002.
 */
public class ExpressionTest {
    /**
     * 四则运算表达式计算
     * @param expression  四则运算表达式
     * @param jo json结果内容
     */
    public static String calculateExpressionValue(String expression,JSONObject jo) {
        if(jo == null) {
            return "0";
        }
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(expression);
        try {
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                String param = m.group(); //${id?} id 匹配
                String field = param.substring(2, param.length() - 1);
                Object value = jo.get(field);
                m.appendReplacement(sb, value != null ? value.toString() : "0");
            }
            m.appendTail(sb);
            ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
            Double d = (Double) se.eval(sb.toString());
            if(d.equals(new Double("Infinity")) || d.equals(new Double("NaN"))) {
                return "0";
            }
            return DigitalConvert.formatAfterPoint(new BigDecimal(d), 2).toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        String template = "(${id1} + ${id2} + ${id3}) / ${id4}";
        String json = "{\"id1\": 1,\"id2\": 2,\"id3\": 3,\"id4\": 4}";
        System.out.print(calculateExpressionValue(template, JSONObject.fromObject(json)));
    }
}
