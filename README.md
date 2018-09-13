# 应用栈服务

## 应用栈服务（Stack Service）的接口设计
| 功能描述/function | 访问端点/endpoint | 请求参数/param | 响应格式/response |
|                    -              |                  -                  |              :-:               |                     :-:          |
| 获取应用栈列表      | GET /stacks              |               -                 |                    response    |
|获取应用栈配置文件| GET /stacks/config/{ticket-id}           |     ticket-id:string:path                          |   response   |
|生成应用栈配置清单模板|GET /stacks/template/{ticket-id}|ticket-id:string:path|response|
|验证部署清单文件|GET  /stacks/verify/{ticket-id}|ticket-id:string:path|response|
|合成DC部署配置文件|GET /stacks/compose/{ticket-id}|ticket-id:string:path|response|

response := {status:integer,message:string,data:object}
