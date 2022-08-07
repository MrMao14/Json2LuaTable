# Json2LuaTable [![Java CI with Maven](https://github.com/MrMao14/Json2LuaTable/actions/workflows/maven.yml/badge.svg)](https://github.com/MrMao14/Json2LuaTable/actions/workflows/maven.yml)
这个项目可以将Json转换为LuaTable的格式
<br>
主要用于部分Lua构建的游戏管理后台
## 如何使用
- 示例
```java
String jsonString = "{\"string\":\"abc\",\"int\":123,\"boolean\":false,\"Object\":{\"obj1\":123,\"obj2\":\"abc\"},\"array\":[\"aaa\",\"bbb\",\"ccc\"]}";
System.out.println(JsonConvertLuaUtil.toLuaTable(jsonString));
```
- 结果
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
## 展向未来
- 转换Json文件到LuaTable文件
- LuaTable字符串转换Json字符串
