# Json2LuaTable
This Project can convert json to lua table
<br>
Mainly used in some lua game management background
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