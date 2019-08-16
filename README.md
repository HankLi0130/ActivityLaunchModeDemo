
# 身為 Android 開發者，你必須知道的 launchMode

## [分享 Android Activity’s launchMode](https://medium.com/@hankli0130/%E5%88%86%E4%BA%AB-android-activitys-launchmode-28e5507dfd86?source=friends_link&sk=f1e8e75454dfb1627a741bd50b7486fa)

## 基本介紹

- 每個 APP 有各自的 Back Stack，當 App 啟動時會建立一個 Back Stack

- 舉例：Gmail
> 1. Activity 1 顯示信件列表，點擊信件後，啟動 Activity 2 顯示信件內容
> 2. 按下返回鍵後，移除 Activity 2，Activity 1 重新工作

![Activity Back Stack Work Flow](https://trello-attachments.s3.amazonaws.com/5bc5a39462a0d88cea46080b/5d48d51969d56915d4f72818/8bc7448adeed7480a694ced7d82a3c12/image.png)

## Back Stack 角色介紹

![Activity Back Stack](https://trello-attachments.s3.amazonaws.com/5bc5a39462a0d88cea46080b/5d48d51969d56915d4f72818/03bad71689dc9ed080a2ede73a68e8db/activity_stack.png)

- Stack 裝載 Task
- Task 裝載 Activity （可直接 Activity 當作 Task）

## 工具介紹

[使用 Adb shell dumpsys 檢測 Android 的 Activity 任務棧](https://blog.csdn.net/xx326664162/article/details/52385720)

- 輸出系統內各 Service 的訊息

```
adb shell dumpsys activity
```

- 只查看 Activity Back Stack

```
adb shell dumpsys activity activities | sed -En -e '/Running activities/,/Run #0/p'
```

- 這個工具很厲害的地方是，它可以將手機內還活著的 Back Stack 全都顯示出來，不單只有目前顯示的 Back Stack

## 四種啟動模式

[Android Developers - Defining launch modes](https://developer.android.com/guide/components/activities/tasks-and-back-stack#TaskLaunchModes)

### 1. standard (the default mode)
- 預設，當 Activity 被啟動，系統建立一個新的 Activity 實例，Activity 可以被實例化多次

### 2. singleTop
- 當 Activity 已經在 Back Stack 最上層，就不再實體化
- 例如：A-B-C-D，將 D 設定為 singleTop，在 D 中開啟 D 保持 A-B-C-D，但在 D 中開啟 B 會變成 A-B-C-D-B，即使 B 設定為 singleTop

### 3. singleTask
- 當 Activity 已經存在 Back Stack 中，就不再實例化
- 例如：A-B-C-D，將 B 設定為 singleTask，在 D 中開啟 B 會變成 A-B，會將上層的 Activity 都移除

### 4. singleInstance
- 跟 singleTask 相同，除了系統不會啟動其他的 Activity 到此 Back Stack，設定為 singleInstance 的 Activity 是此 Back Stack 單一且唯一的 Activity，此 Activity 啟動的任何其他 Activity 都會被丟到另一個 Back Stack
- 例如：A，將 A 設定為 singleInstance，在 A 開啟 B 會變成
A (Back Stack 1)
B (Back Stack 2)