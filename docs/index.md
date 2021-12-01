# Lib项目说明

Library是一个功能非常强悍的XXXX库，使用XXXX + XXXX + XXXX组合进行封装。

> 支持多种Http请求方式，提供大量丰富的网络请求拦截器，支持三种方式进行网络请求，支持自定义网络请求协议，提供统一的异常处理机制，支持多种缓存策略，支持自定义请求响应实体，提供丰富的API方法，极大便捷了网络开发的效率。

## 功能特点

* 支持默认、全局、局部三个层次的配置功能。
* 支持动态配置和自定义底层框架OkHttpClient、Retrofit.
* 加入基础ApiService，减少Api冗余。
* 支持多种方式访问网络GET、POST、PUT、DELETE等请求协议。
* 支持网络缓存,六种缓存策略可选,涵盖大多数业务场景。
* 支持固定添加header和动态添加header。

## 预览

<img src="./resources/screenshots/screenshot_01.jpg" width="50%"/>

## 开始使用
因为依赖的关系，KennieLibTemplate 目前仅支持 AndroidX 作为基础进行开发，若您正在使用最新版本的 Android Studio，那么默认创建的项目就是使用 AndroidX 作为底层框架的。

**以下两种引入方式请任选其一。**

> **使用前请查看注意事项**，当前版本仅支持AndroidX

### 📥引入

#### 方式一：Gradle 引入  jitPack 源

1) 在 project 的 build.gradle 文件中找到 `allprojects{}` 代码块添加以下代码：

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }      //增加 jitPack Maven 仓库
    }
}
```

⚠️请注意，使用 Android Studio 北极狐版本（Arctic Fox）创建的项目，需要您前往 settings.gradle 添加上述 jitpack 仓库配置。

2) 在 app 的 build.gradle 文件中找到 `dependencies{}` 代码块，并在其中加入以下语句：

Latest Version：[![](https://jitpack.io/v/kennielab/KennieLibTemplate.svg)](https://jitpack.io/#kennielab/KennieLibTemplate)

```
def lib = "0.0.2"
implementation "com.github.kennielab:KennieLibTemplate:${lib}"
```

#### 方式二：直接引入 AAR 包文件

请前往 [Release](https://github.com/kongzue/DialogX/releases) 页面根据需要版本的下载 AAR 包文件。

1) 将 AAR 放入 libs 目录。

2) 在 Module 的 build.gradle 里加入以下代码：
```
build.gradle
repositories{
    flatDir {
        dirs 'libs'
    }
}

implementation(name: 'AAR文件名', ext: 'aar')
```

## 注意事项

> **使用前请查看注意事项**，当前版本仅支持AndroidX

### 构建环境

> 最低支持api 21

    compileSdk 30
    minSdk 21
    targetSdk 30

> 开发环境

    AndroidStudio ArcticFox 2020.3.1
    JDK 1.8 || JDK 11
    kotlin 1.5.31
    gradle-7.0.2-bin & gradle 7.0.2

> 运行环境

   手机端 Android7.0 ~ Android 11.0

## 联系方式
- 微信：**lkweixh**
- 邮箱：245794335@qq.com
