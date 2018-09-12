# 应用栈服务

## 部署工单数据结构(Deploy Order)
```
id: string #工单ID
topic: string #工单主题
description: string  #工单描述
initiator: string #工单发起人
create-time: timestamp #工单发起时间
approvers: string[]{3} #工单审批人，长度为3的字符串数组，第一个代表“开发审批人”，第二个代表“测试审批人”，第三个代表“产品审批人”
inventory: #部署清单
  stack: 
    name:  string #栈名，即产品（应用）的名称
    service: #代表应用栈中的服务，其值为一个数组，数组中每个元素有svc-name和svc-host属性。其中svc-name表示应用栈中一个服务的名字，svc-host表示，这个服务需要部署到“客户生产环境”中主机的ip地址。
      - {svc-name: string, svc-host: string}
      - {svc-name: string, svc-host: string}
      - {svc-name: string, svc-host: string}
```

## 应用栈服务（Stack Service）的接口设计
| 功能描述/function | 访问端点/endpoint | 请求参数/param | 响应格式/response |
|                    -              |                  -                  |              :-:               |                     :-:          |
| 获取应用栈列表      | GET /stacks              |               -                 |                    string[]    |
|获取应用栈配置文件| GET /stacks/{stack-id}/config           |     stack-id:string:path                          |   json   |
|生成应用栈配置清单模板|GET /stacks/{stack-id}/template|stack-id:string:path|json|
|验证部署清单文件|POST  /stacks/verify|inventory:object:body|{success:boolean,message:string}|
|合成DC部署配置文件|POST /stacks/{stack-id}/compose|inventory:object:body|json|

