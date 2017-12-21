<span >注册</span>
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
- **请求示例**
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


<span >登陆</span>
------
- **请求URL**
> [user/login](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| userName|  String,**不可为空**</mark>|  用户名|
| pwd|   String,**不可为空**|  密码|

- **返回示例**
>    
```java 
json请求
{
  "userName":"xuyh",
  "pwd":"ascsd",
  
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
    "result": "c0c2e22d-2dcd-4bda-88c6-13629f9bc67c"   //token
}
用户名已存在
{
    "status": "0",
    "result": "username or pwd is wrong"
}
```


<span >更换头像</span>
------
- **请求URL**
> [user/updateImg/{imgUrl}](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| token|  |  用户标识，存在HTTP头部|




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
    "result": "succeed"   //token
}
用户名已存在
{
    "status": "003",
    "result": "no permission "
}
```



<span >发布推广商品</span>
------
- **请求URL**
> [share/addShare/](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| token|  |  用户标识，存在HTTP头部|
- **请求示例**
>    
```java 

{
	"title":"淘宝爆款",
	"content":"asdasd",
	"url":"www.taobao.com",
	"img":"asdasda",
	"price":"15.50"
}



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
    "result": "succeed"   //token
}

```


<span >查看推广商品</span>
------
- **请求URL**
> [share/getShare/{shareId}](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| token| 可带可不带 |  用户标识，存在HTTP头部|




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
    "status": "001",
    "result": {
        "id": 5,
        "userId": 5,
        "title": "淘宝爆款",
        "content": "asdasd",
        "url": "www.taobao.com",  可能为null，null则不显示
        "img": "asdasda",
        "price": "15.50",
        "createTime": "2017/12/21 14:13:34"
    }
}
```


<span >获取推广商品的购买链接</span>
------
- **请求URL**
> [share/getUrl/{shareId}](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
| token| 可带可不带，不带会返回没有权限 |  用户标识，存在HTTP头部|




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
    "status": "001",
    "result": "www.taobao.com"
}
```

<span >修改推广商品</span>
------
- **请求URL**
> [share/updateShare](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
- **请求示例**
>    
```java 

{
    "id":2,
	"title":"淘宝爆款",
	"content":"asdasd",
	"url":"www.taobao.com",
	"img":"asdasda",
	"price":"15.50"
}




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
    "status": "001",
    "result": "www.taobao.com"
}
```


<span >删除推广商品</span>
------
- **请求URL**
> [share/delShare/{id}](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
|id||推广商品id|





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
    "status": "001",
    "result": "succeed"
}
```


<span >添加收藏</span>
------
- **请求URL**
> [star/addStar/{shareId}](#)
> - **请求方式** 
>**POST**
- **请求参数**
>
 | 请求参数      |     参数类型 |   参数说明   |
| :-------- | :--------| :------ |
|id||推广商品id|
|token||token|





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
    "status": "001",
    "result": "succeed"
}
```
