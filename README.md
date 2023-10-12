# Android Client SDK for OpenIM 👨‍💻💬

Use this SDK to add instant messaging capabilities to your Android app. By connecting to a self-hosted [OpenIM](https://www.openim.online/) server, you can quickly integrate instant messaging capabilities into your app with just a few lines of code.


The underlying SDK core is implemented in [OpenIM SDK Core](https://github.com/openimsdk/openim-sdk-core). Using [gomobile](https://github.com/golang/mobile), it can be compiled into an AAR file for Android integration. Android interacts with the [OpenIM SDK Core](https://github.com/openimsdk/openim-sdk-core) through JSON, and the SDK exposes a re-encapsulated API for easy usage. In terms of data storage, Android utilizes the SQLite layer provided internally by the [OpenIM SDK Core](https://github.com/openimsdk/openim-sdk-core).




## Documentation 📚

Visit [https://doc.rentsoft.cn/](https://doc.rentsoft.cn/) for detailed documentation and guides.

For the SDK reference, see [https://doc.rentsoft.cn/sdks/quickstart/android](https://doc.rentsoft.cn/sdks/quickstart/android).

## Installation 💻
### Adding repositories
```
 maven { url 'https://open-im-online.rentsoft.cn:51000/repository/maven2/' }
```
### Adding Dependencies
```
   implementation 'io.openim:android-sdk:last_version@aar'
   implementation 'io.openim:core-sdk:last_versio@aar'
   implementation 'com.google.code.gson:gson:2.9.0'
```
## Usage 🚀

The following examples demonstrate how to use the SDK.
### Importing the SDK and initialize

```java
package io.openim.android.sdk;
```
### Initialize
```java
OpenIMClient.getInstance().initSDK(
	app  //Application
    2,  //Platform code
    "Your IM server address",
    "Your IM server socket address",
    getStorageDir(), //Storage path
    1,
    "minio",
    "",
    IMEvent.getInstance().connListener
);

```
### Logging In and Listening for Connection Status

> Note1: You need to set up the listeners first and then log in.


```java
// Set listener
 //User Profile Change Listener
 OpenIMClient.getInstance().userInfoManager.setOnUserListener(new OnUserListener() {});
 //Message-related Listener
 OpenIMClient.getInstance().messageManager.setAdvancedMsgListener(new OnAdvanceMsgListener(){}）
 //Friendship Status Change Listener
 OpenIMClient.getInstance().friendshipManager.setOnFriendshipListener(new OnFriendshipListener() {})
 //Conversation-related Listener
 OpenIMClient.getInstance().conversationManager.setOnConversationListener(new OnConversationListener()
 //Group-related Listener
 OpenIMClient.getInstance().groupManager.setOnGroupListener(new OnGroupListener(){})

// Retrieve the profile of the currently logged-in user
public void login() {
        Parameter parameter = getParameter(null);
	//1.Log in to your business server to obtain the userID and token.
        N.API(OpenIMService.class).login(parameter.buildJsonBody())
            .compose(N.IOMain())
            .subscribe(new NetObserver<ResponseBody>(getContext()) {

                @Override
                public void onSuccess(ResponseBody o) {
                    try {
                        String body = o.string();
                        Base<LoginCertificate> loginCertificate = GsonHel.dataObject(body, LoginCertificate.class);
                        if (loginCertificate.errCode != 0) {
                            IView.err(loginCertificate.errMsg);
                            return;
                        }
			//2.Use the userID and token obtained in step 1 to log in to the IM (Instant Messaging) server.
                        OpenIMClient.getInstance().login(new OnBase<String>() {
                            @Override
                            public void onError(int code, String error) {
                                IView.err(error);
                            }

                            @Override
                            public void onSuccess(String data) {
                                //Cache login information and start a delightful chat
                   
                            }
                        }, loginCertificate.data.userID, loginCertificate.data.token);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                protected void onFailure(Throwable e) {
                    IView.err(e.getMessage());
                }
            });
    }
```

To log into the IM server, you need to create an account and obtain a user ID and token. Refer to the [access token documentation](https://doc.rentsoft.cn/restapi/userManagement/userRegister) for details.

### Receiving and Sending Messages 💬

OpenIM makes it easy to send and receive messages. By default, there is no restriction on having a friend relationship to send messages (although you can configure other policies on the server). If you know the user ID of the recipient, you can conveniently send a message to them.

```java
//Send
Message  msg = OpenIMClient.getInstance().messageManager.createTextMessage("hello openim");
OpenIMClient.getInstance().messageManager.sendMessage(new OnMsgSendCallback() {
            @Override
            public void onError(int code, String error) {
             // Failed to send message ❌
            }

            @Override
            public void onProgress(long progress) {
             //Sending...
            }

            @Override
            public void onSuccess(Message message) {
             // Message sent successfully ✉️	

            }
        }, msg, userID, groupID, null);


//Receive
OpenIMClient.getInstance().messageManager.setAdvancedMsgListener(new OnAdvanceMsgListener(){
  @Override
            public void onRecvNewMessage(Message msg) {
                // Received new message 📨
            }
}）
```

## Examples 🌟

You can find a demo Android app that uses the SDK in the [open-im-android-demo](https://github.com/openimsdk/open-im-android-demo) repository.


## Community :busts_in_silhouette:

- 📚 [OpenIM Community](https://github.com/OpenIMSDK/community)
- 💕 [OpenIM Interest Group](https://github.com/Openim-sigs)
- 🚀 [Join our Slack community](https://join.slack.com/t/openimsdk/shared_invite/zt-22720d66b-o_FvKxMTGXtcnnnHiMqe9Q)
- :eyes: [Join our wechat (微信群)](https://openim-1253691595.cos.ap-nanjing.myqcloud.com/WechatIMG20.jpeg)

## Community Meetings :calendar:

We want anyone to get involved in our community and contributing code, we offer gifts and rewards, and we welcome you to join us every Thursday night.

Our conference is in the [OpenIM Slack](https://join.slack.com/t/openimsdk/shared_invite/zt-22720d66b-o_FvKxMTGXtcnnnHiMqe9Q) 🎯, then you can search the Open-IM-Server pipeline to join

We take notes of each [biweekly meeting](https://github.com/orgs/OpenIMSDK/discussions/categories/meeting) in [GitHub discussions](https://github.com/openimsdk/open-im-server/discussions/categories/meeting), Our historical meeting notes, as well as replays of the meetings are available at [Google Docs :bookmark_tabs:](https://docs.google.com/document/d/1nx8MDpuG74NASx081JcCpxPgDITNTpIIos0DS6Vr9GU/edit?usp=sharing).

## Who are using OpenIM :eyes:

Check out our [user case studies](https://github.com/OpenIMSDK/community/blob/main/ADOPTERS.md) page for a list of the project users. Don't hesitate to leave a [📝comment](https://github.com/openimsdk/open-im-server/issues/379) and share your use case.

## License :page_facing_up:

OpenIM is licensed under the Apache 2.0 license. See [LICENSE](https://github.com/openimsdk/open-im-server/tree/main/LICENSE) for the full license text.
