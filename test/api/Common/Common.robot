*** Settings ***
Documentation                           该文档是应用栈微服务的接口测试公共模块关键字集文档
Library                                 FATL
# Library                                 String
# Library                                 Collections

*** Variables ***
# ${URL}                                  http://stack-service.ycbs.test.fzyun.io
${URL}                                  http://stack-service.ycbs.dev.fzyun.io
${API_VERSION}                          v1
# 获取应用栈列表
${STACK_URI}                            /${API_VERSION}/stacks
# 获取应用栈配置文件
${STACK_CONFIG_URI}                     /${API_VERSION}/stacks/config/{ticket-id}
# 生成应用栈配置清单模板
${STACK_TEMPLATE_URI}                   /${API_VERSION}/stacks/template/{ticket-id}
# 验证部署清单文件
${STACK_VERIFY_URI}                     /${API_VERSION}/stacks/verify/{ticket-id}
# 合成DC部署配置文件
${STACK_COMPOSE_URI}                    /${API_VERSION}/stacks/compose/{ticket-id}

# mock
${CONIFG}                               /${API_VERSION}/config
${APPROVE_SERVICE_MOCK_URL}             https://mock.fzyun.io/mock/5b9f469fde6fed001a7fd35c/approve_service
${APPROVE_INFO_URI}                     /v1/ticket/{id}

*** Keywords ***
Create Session
    Fapi Headers Reset
    Fapi Create Session                 ${URL}
