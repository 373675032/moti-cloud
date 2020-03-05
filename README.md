# moti-cloud
莫提网盘：适合初学者，喜欢的小伙伴可以点上面的Star支持一下嘛！

[网盘地址](http://xuewei.world/moti-cloud/)          [视频演示](https://www.bilibili.com/video/av92186731)

### 注意

拉取项目到本地后，你需要修改一下配置信息

- `application.yml`：修改数据源信息
- `config.DruidConfig`：修改druid登录的用户名和密码
- `utils.FtpUtil`：修改FTP服务器的基本信息
- `resources.qqconnectconfig.properties`：修改`app_ID` 和 `app_KEY`和 `redirect_URI`

### 项目主要功能

- 使用QQ第三方登录，简化用户注册与登录。
- 文件的管理，上传、下载、重命名、删除、查看统计数据、分类管理等。
- 文件夹的管理，创建、删除、重命名。
- 文件的分享，支持通过链接和二维码的分享方式。

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

[Docker搭建FTP服务](https://www.bilibili.com/video/av87259459)

[使用Docker部署SpringBoot应用](https://www.bilibili.com/video/av88690709)

### 欢迎关注我的B站账号

[我是莫提](https://space.bilibili.com/301320288)

[我的个人博客](http://xuewei.world)



### 写在最后

由于技术有限，难免会有一些设计不合理之处，有好的想法，欢迎在b站私信交流！


