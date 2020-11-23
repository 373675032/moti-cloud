# moti-cloud
莫提网盘-v2.0：适合初学者，喜欢的小伙伴可以点上面的Star支持一下嘛！

[下载莫提网盘-v1.0](https://github.com/373675032/moti-cloud/releases)

[网盘地址](http://xuewei.world/moti-cloud/)          [视频演示](https://www.bilibili.com/video/BV1p7411y7aQ)

### 注意

拉取项目到本地后，你需要修改一下配置信息

- `application.yml`：修改数据源信息以及邮箱服务端信息
- `config.DruidConfig`：修改druid登录的用户名和密码
- `utils.FtpUtil`：修改FTP服务器的基本信息
- `utils.MailUtils`：修改邮箱服务端发送方的邮箱
- `resources.qqconnectconfig.properties`：修改`app_ID` 和 `app_KEY`和 `redirect_URI`

### 项目主要功能

- 用户的邮箱注册、验证码验证以及用户登录。
- 引入QQ第三方登录，为用户提供便捷的登录通道。
- 不需要注册账号，也可以上传满足条件的临时文件，但是只4小时内有效。
- 文件的管理，上传、下载、重命名、删除、查看统计数据、分类管理等。
- 文件夹的管理，创建、删除、重命名。
- 文件的分享，支持通过链接和二维码的分享方式。
- 区分普通用户和管理员的角色，管理员可以修改普通用户的使用权限和网盘容量。

### 使用哪些技术

#### 前端

- HTML、CSS、JavaScript、JQuery
- BootStrap以及多个插件

#### 后端

- SpringBoot + MyBatis
- EhCache缓存
- ThymeLeaf 模板引擎
- 腾讯QQ 第三方登录
- Ftp工具类、二维码工具类

#### 部署

- 阿里云轻量应用服务器
- Docker 环境
- FTP 服务
- MySQL 数据库

### 福利

[怎样引入QQ登录](https://www.bilibili.com/video/av90710722)


[使用Docker部署SpringBoot应用](https://www.bilibili.com/video/av88690709)

### 欢迎关注我的B站账号

[我是莫提](https://space.bilibili.com/301320288)

[我的个人博客](http://xuewei.world)



### 写在最后

由于技术有限，难免会有一些设计不合理之处，有好的想法，欢迎在b站私信交流！

**开源不易，请作者喝杯咖啡吧~☕**

![](http://xuewei.world:8000/wp-content/uploads/2020/06/image-219x300.png)
