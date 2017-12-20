<span >登陆</span>
------
- **请求URL**
> [user/register](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| userName|  String,**不可为空**</mark>|  用户名|
| pwd|   String,**不可为空**|  密码|
|phone| String,**不可为空**|手机|
- **返回示例**
>    
```java 
json请求
{
  "userName":"xuyh",
  "pwd":"ascsd",
  "phone":"18758290214"}
}
```

- **返回参数**
> 
| 返回参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| status|   String|  状态|
|result| String|结果信息|
- **返回示例**
>    
```java 
成功
{
    "status": "1",
    "result": "succeed"
}
用户名已存在
{
    "status": "0",
    "result": "username already exists"
}
```