package com.mrmao;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: MrMao
 * @Date: 2022/8/2
 **/
public class JsonConvertUtil {

    /**
     * Get system new line character to adapt windows and macOS
     */
    private static final String NEW_LINE_CHARACTER = System.getProperty("line.separator");

    /**
     * Convert JsonString to Lua Table
     * @param jsonObject JsonString to be converted
     * @return Lua table String
     */
    public static String toLuaTable(JSONObject jsonObject) {

        StringBuilder stringBuilder = new StringBuilder();
        //Bypass start with [return : ]
        stringBuilder.append("{").append(NEW_LINE_CHARACTER);
        //Json key set
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            Object str = jsonObject.getObj(entry.getKey());
            int childLevel = 1;
            if (str.toString().startsWith("[")) {
                //Append list beginning
                stringBuilder.append("  [\"").append(entry.getKey()).append("\"]")
                        .append(" = {").append(NEW_LINE_CHARACTER);
                JSONArray objects = JSONUtil.parseArray(str);
                //Start append
                Iterator<Object> iterator = objects.stream().iterator();
                while (iterator.hasNext()) {
                    stringBuilder.append("    ");
                    //Start process Value
                    valueHandle(stringBuilder, iterator.next());
                }
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
                stringBuilder.append("  },").append(NEW_LINE_CHARACTER);
            } else {
                //Format String
                for (int i = 0; i < childLevel; i++) {
                    stringBuilder.append("  ");
                }
                //Append key
                stringBuilder.append("[\"").append(entry.getKey()).append("\"]")
                        .append(" = ");
                //Start process Value
                valueHandle(stringBuilder, str);
            }
        }
        //Remove last ","
        stringBuilder.delete(stringBuilder.lastIndexOf(","), stringBuilder.length());
        stringBuilder.append(NEW_LINE_CHARACTER).append("}");

        return stringBuilder.toString();
    }

    private static void appendChildJson(String stringBuilder, JSONObject jsonObject) {
        //todo
    }

    /**
     * According to object type to append
     *
     * @param stringBuilder Concatenated string
     * @param str           To be concatenated field
     */
    private static void valueHandle(StringBuilder stringBuilder, Object str) {
        if (str.getClass() == String.class) {
            stringBuilder.append("\"").append(str).append("\"");
        } else if (str.getClass() == Boolean.class) {
            //Boolean in lua special
            boolean booleanValue = Boolean.parseBoolean(String.valueOf(str));
            if (!booleanValue) {
                stringBuilder.append("nil");
            } else {
                stringBuilder.append("true");
            }
        } else {
            //Number dont need [""]
            stringBuilder.append(str);
        }
        stringBuilder.append(",").append(NEW_LINE_CHARACTER);
    }

}
