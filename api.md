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


获取个人资料
user/getUser          get
带token
返回示例
{
    "status": "001",
    "result": {
        "id": 5,
        "userName": "xuyh",
        "pwd": null,
        "phone": "18758290214",
        "img": "sad",
        "token": "fdbdec83-45dd-427f-9ac1-c4f1b0a798ee"
    }
}

删除收藏
star/delStar/{starId}    post
带token
返回
{
    "status": "001",
    "result": "succeed"
}


获取收藏
star/getStar           get
带token
返回
{
    "status": "001",
    "result": [
        {
            "id": 3,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:07:22"
        },
        {
            "id": 4,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:29"
        }
        
    ]
}


获取自己已查看的购买链接
getUrls    get
返回
{
    "status": "003",
    "result": [
        {
            "id": 5,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:34"
        },
        {
                    "id": 5,
                    "userId": 5,
                    "title": "淘宝爆款",
                    "content": "asdasd",
                    "url": "www.taobao.com",
                    "img": "asdasda",
                    "price": "15.50",
                    "createTime": "2017/12/21 14:13:34"
                }
    ]
}


评价
addEvaluation  post
提交：
{
	"shareId":6,
	"score":4,
	"content":"好评",
	"img":"www.abidas.sdasd"
}

返回：
{
    "status": "001",
    "result": "succeed"
}


获取评价列表
getEvaluations/{shareId}   get
返回
{
    "status": "001",
    "result": [
        {
            "id": 1,
            "shareId": 6,
            "userId": 5,
            "score": 4,
            "content": "好评",
            "img": "www.abidas.sdasd"
        },
        {
            "id": 2,
            "shareId": 6,
            "userId": 5,
            "score": 4,
            "content": "好评",
            "img": "www.abidas.sdasd"
        },
        {
            "id": 3,
            "shareId": 6,
            "userId": 5,
            "score": 4,
            "content": "好评",
            "img": "www.abidas.sdasd"
        }
    ]
}


搜索
share/seShare/{keyword}
post
返回
{
    "status": "001",
    "result": [
        {
            "id": 3,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:07:22"
        },
        {
            "id": 4,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:29"
        },
        {
            "id": 5,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:34"
        },
        {
            "id": 7,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:38"
        },
        {
            "id": 8,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:39"
        },
        {
            "id": 9,
            "userId": 5,
            "title": "淘宝爆款",
            "content": "asdasd",
            "url": "www.taobao.com",
            "img": "asdasda",
            "price": "15.50",
            "createTime": "2017/12/21 14:13:40"
        }
    ]
}

