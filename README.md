# KennieFilterMenu

<p align="center"><img src="./resources/screenshots/logo.png" width="20%"/></p>

<p align="center">
    <strong>下拉筛选菜单</strong>
    <br>
    <a href="https://kennielab.github.io/KennieLibTemplate/">使用文档</a>
    <br>
</p>

<p align="center">
<img src="https://img.shields.io/badge/language-java-blue.svg"/>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-green.svg"/>
</p>



## 简介

下拉筛选菜单

如有任何疑问或者Bug，请在 github 上公开讨论[技术问题](https://github.com/kennielab/KennieLetterIndexBar/issues)

**开源不易，如果喜欢的话希望给个 `Star` 或 `Fork` ^_^ ，谢谢~~**

## 功能及特点

- XX、XX、XX、XX；

## APP下载

- [GitHub下载](https://gitee.com/kenniecode/kennie-android/tree/template%2Flibrary/releases) [![](https://img.shields.io/badge/Download-apk-green.svg)](https://gitee.com/kenniecode/kennie-android/tree/template%2Flibrary/releases/app-release.apk)
- 扫码

![](./resources/download_qr_code.png)


## 预览

<!-- <img src="./resources/screenshots/screenshot_01.jpg" width="50%"/> -->

| ![](resources/screenshots/01.jpg) | ![](resources/screenshots/02.jpg) | ![](resources/screenshots/03.jpg) | ![](resources/screenshots/04.jpg) |
| --- | --- | --- | --- |
| ![](resources/screenshots/05.jpg) | ![](resources/screenshots/06.jpg) | ![](art/07.jpg) | ![](resources/screenshots/08.jpg) |
| ![](resources/screenshots/01.gif) | ![](resources/screenshots/02.gif) | ![](art/03.gif) | ![](resources/screenshots/04.gif) |


## 开始使用
因为依赖的关系，KennieFilterMenu 目前仅支持 AndroidX 作为基础进行开发，若您正在使用最新版本的 Android Studio，那么默认创建的项目就是使用 AndroidX 作为底层框架的。
> **使用前请查看注意事项**，当前版本仅支持AndroidX

### 📥引入

#### 方式一：Gradle 引入  jitPack 源

<div>

Latest Version：[![](https://jitpack.io/v/kennielab/KennieLibTemplate.svg)](https://jitpack.io/#kennielab/KennieLibTemplate)

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

```
def lib = "0.0.2"
implementation "com.github.kennielab:KennieFilterMenu:${lib}"
```

### Wiki使用

具体的使用说明，请参阅 [DOC](https://kennielab.github.io/KennieFilterMenu/)

## 更新日志
- [详细日志](./UPDATELOG.md)

### 1.0.0

- XXXXXXXX

## 赞赏

**如果您觉得还不错，您可以打赏哦，您的支持将是我持续维护的动力。我将会列出所有打赏人员的清单在下方作为凭证，打赏前请留下打赏项目的备注！**

|  微信支付 |
|--|
|  ![SMOOTH](./resources/pay/微信支付.jpg) |

感谢下面小伙伴的打赏：

姓名 | 金额 | 方式
:-|:-|:-
*** | **￥ | 微信
*** | *￥ | 支付宝

## 感谢

- [AliyunGradleConfig](https://github.com/gzu-liyujiang/AliyunGradleConfig)
- [Android 代码规范文档](https://gitee.com/getActivity/AndroidCodeStandard)
- [阿里矢量图](https://www.iconfont.cn/)
- [花瓣](https://huaban.com/)

## LICENSE

```
Copyright (c) 2020-2021 kennie

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```