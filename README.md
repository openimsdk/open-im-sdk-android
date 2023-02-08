## 可以免费使用，必须在app启动页加上 (由OpenIM提供技术支持)
![avatar](https://github.com/OpenIMSDK/OpenIM-Docs/blob/main/docs/images/WechatIMG20.jpeg)

[中文文档](README.zh-cn.md)

#### Use（使用）

##### 1，Add repositories（添加仓库地址）

```
    maven { url 'https://open-im-online.rentsoft.cn:51000/repository/maven2/' }
```

##### 2，Add dependencies（添加依赖）

```
    implementation 'io.openim:android-sdk:2.3.5.6@aar'
    implementation 'io.openim:core-sdk:2.3.5-t13@aar'
    implementation 'com.google.code.gson:gson:2.9.0'
```

#### Proguard rules（混淆规则）
```
# OpenIM
-keep class io.openim.**{*;}
-keep class open_im_sdk.**{*;}
-keep class open_im_sdk_callback.**{*;}
```
