*** Settings ***
Documentation                           该文档是应用栈服务的接口测试
Resource                                ../Common/Common.robot
Force Tags                              接口测试            应用栈服务           作者：李尧
Suite Setup                             Create Session
# Test Setup
# Test Teardown
Suite Teardown                          Fapi Delete All Sessions

*** Variables ***


*** Keywords ***
Get Ticket Id
    Fapi Get                            ${STACK_URI}
    Fapi Status Should Be Succeed
    ${data} =                           Fapi data To Object
    [return]                            ${}

*** Test Cases ***
获取应用栈列表
    Fapi Get                            ${STACK_URI}
    Fapi Status Should Be Succeed
    ${data} =                           Fapi data To Object
    ${count} =                          Get Length          ${data}
    Should Be True                      ${count} >= ${0}

# 获取应用栈配置文件
# ${STACK_CONFIG_URI}                     /${API_VERSION}/stacks/config/{ticket-id}


# 生成应用栈配置清单模板
# ${STACK_TEMPLATE_URI}                   /${API_VERSION}/stacks/template/{ticket-id}


# 验证部署清单文件
# ${STACK_VERIFY_URI}                     /${API_VERSION}/stacks/verify/{ticket-id}


# 合成DC部署配置文件
# ${STACK_COMPOSE_URI}                    /${API_VERSION}/stacks/compose/{ticket-id}
