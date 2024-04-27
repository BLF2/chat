# Chat系统
## 1 环境
+ JDK 17.0.4
+ Mysql 8.0.33
+ Maven 3.8.1


## 2 框架
+ Spring Boot 3.0.2
+ Mybatis Plus 3.5.3.2
+ Druid 1.2.18

## 3 mysql脚本

```sql
-- 创建数据库
CREATE DATABASE `chat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- 创建user_info表
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