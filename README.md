# Json2LuaTable [![Java CI with Maven](https://github.com/MrMao14/Json2LuaTable/actions/workflows/maven.yml/badge.svg)](https://github.com/MrMao14/Json2LuaTable/actions/workflows/maven.yml)
This Project can convert json to lua table
<br>
Mainly used in some lua game management background
<br>
你可以在这里查看[中文文档](https://github.com/MrMao14/Json2LuaTable/blob/main/README_ZH.md)
## How to use
- code
```java
String jsonString = "{\"string\":\"abc\",\"int\":123,\"boolean\":false,\"Object\":{\"obj1\":123,\"obj2\":\"abc\"},\"array\":[\"aaa\",\"bbb\",\"ccc\"]}";
System.out.println(JsonConvertLuaUtil.toLuaTable(jsonString));
```
- result
```
{
  ["string"] = "abc",
  ["int"] = 123,
  ["boolean"] = nil,
  ["Object"] = {
    ["obj1"] = 123,
    ["obj2"] = "abc"
  },
  ["array"] = [
    "aaa",
    "bbb",
    "ccc"
  ]
}
```
## Feature
- Convert json file to lua table file
- lua table json to json String
