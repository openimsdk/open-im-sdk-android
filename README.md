## 可以免费使用，必须在app启动页加上 (由OpenIM提供技术支持)

[中文文档](README.zh-cn.md)

#### Use（使用）

##### 1，Add repositories（添加仓库地址）

```
maven {
    allowInsecureProtocol = true
    url 'http://121.37.25.71:8081/repository/maven-releases/'
}
```

##### 2，Add dependencies（添加依赖）

```
    implementation 'io.openim:android-sdk:2.0.10@aar'
    implementation 'io.openim:client-sdk:2.0.32@aar'
```

#### Proguard rules（混淆规则）
```
# OpenIM
-keep class io.openim.**{*;}
-keep class open_im_sdk.**{*;}
-keep class open_im_sdk_callback.**{*;}
```
