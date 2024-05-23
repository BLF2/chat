# Chat系统
## 一 环境
+ JDK 17.0.4
+ Mysql 8.0.33
+ Maven 3.8.1


## 二 框架
+ Spring Boot 3.0.2
+ Mybatis Plus 3.5.3.2
+ Bootstrap 3.x
+ JQuery 1.21
## 三 mysql脚本

```sql
-- 创建数据库
drop table if exists user_info;
create table user_info(
    id bigint primary key auto_increment comment '物理主键',
    username varchar(20) NOT NULL comment '用户登录名',
    `password` varchar(32) NOT NULL comment '密码，MD5格式',
    real_name varchar(50) NOT NULL comment '真实姓名',
    gmt_created datetime default current_timestamp comment '创建时间',
    creator varchar(20) comment '创建人',
    gmt_modified datetime default current_timestamp comment '最后修改时间',
    modifier varchar(20) comment '最后修改人',
    INDEX idx_username(`username`)
) comment '用户信息表';
-- 初始化一条数据进去
insert into user_info values(default,'admin',MD5('admin'),'admin',now(),'admin',now(),'admin');
```

## 四. 本地启动
1. 准备环境：Mysql8.0+，IDEA（配置好Maven），JDK17+，Chrome，
2. 星火大模型注册并拿到3.5版本的AppId，AppSecret，AppKey，获取地址：[https://xinghuo.xfyun.cn/](https://xinghuo.xfyun.cn/)
3. Mysql新建数据，命名为`chat`，默认字符集是`utf8mb4`,默认排序规则`utf8mb4_0900_ai_ci`
4. 执行上面《三》中的脚本
5. IDEA导入本项目
6. 修改`application.yml`中的数据库连接信息，星火大模型信息，日志文件存放路径
7. 启动
8. 浏览器输入`http://localhost:8080/chat/index.html` 默认用户名密码`admin/admin`