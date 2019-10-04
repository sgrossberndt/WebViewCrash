# Crash of WebView using HTML `<select>` element and `androidx.appcompat:appcompat:1.1.0`

This code example demonstrates a crash in Android versions `5.x` and `6.x` when using a `WebView` in
combination with the current version `1.1.0` of the `androidx.appcompat:appcompat` AndroidX
AppCompat component. It does not happen with version `androidx.appcompat:appcompat:1.0.2`.

In Android 5.0 (API 21) the app already crashes on start, in Android 6.0 (API 23) it crashes on
tapping the `<select>` element.

### HTML Code
```
<html>
	<body>
		<select>
			<option>1</option>
			<option>2</option>
		</select>
	</body>
</html>
```

## Android 5.0 (API 21)

App crashes on start:

```
10-04 09:22:04.998 3308-3308/? W/ResourceType: No known package when getting value for resource number 0x02040002
10-04 09:22:04.998 3308-3308/? D/AndroidRuntime: Shutting down VM
    
    --------- beginning of crash
10-04 09:22:04.999 3308-3308/? E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.crashtest.webviewcrash, PID: 3308
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.crashtest.webviewcrash/com.example.crashtest.webviewcrash.MainActivity}: android.view.InflateException: Binary XML file line #11: Error inflating class android.webkit.WebView
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2298)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2360)
        at android.app.ActivityThread.access$800(ActivityThread.java:144)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1278)
        at android.os.Handler.dispatchMessage(Handler.java:102)
        at android.os.Looper.loop(Looper.java:135)
        at android.app.ActivityThread.main(ActivityThread.java:5221)
        at java.lang.reflect.Method.invoke(Native Method)
        at java.lang.reflect.Method.invoke(Method.java:372)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:899)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:694)
     Caused by: android.view.InflateException: Binary XML file line #11: Error inflating class android.webkit.WebView
        at android.view.LayoutInflater.createView(LayoutInflater.java:633)
        at com.android.internal.policy.impl.PhoneLayoutInflater.onCreateView(PhoneLayoutInflater.java:55)
        at android.view.LayoutInflater.onCreateView(LayoutInflater.java:682)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:741)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:806)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:504)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:414)
        at com.example.crashtest.webviewcrash.ui.main.MainFragment.onCreateView(MainFragment.java:28)
        at androidx.fragment.app.Fragment.performCreateView(Fragment.java:2600)
        at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:881)
        at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238)
        at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303)
        at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2659)
        at androidx.fragment.app.FragmentManagerImpl.dispatchActivityCreated(FragmentManagerImpl.java:2613)
        at androidx.fragment.app.FragmentController.dispatchActivityCreated(FragmentController.java:246)
        at androidx.fragment.app.FragmentActivity.onStart(FragmentActivity.java:542)
        at androidx.appcompat.app.AppCompatActivity.onStart(AppCompatActivity.java:201)
        at android.app.Instrumentation.callActivityOnStart(Instrumentation.java:1220)
        at android.app.Activity.performStart(Activity.java:5953)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2261)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2360) 
        at android.app.ActivityThread.access$800(ActivityThread.java:144) 
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1278) 
        at android.os.Handler.dispatchMessage(Handler.java:102) 
        at android.os.Looper.loop(Looper.java:135) 
        at android.app.ActivityThread.main(ActivityThread.java:5221) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at java.lang.reflect.Method.invoke(Method.java:372) 
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:899) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:694) 
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Constructor.newInstance(Native Method)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:288)
        at android.view.LayoutInflater.createView(LayoutInflater.java:607)
        at com.android.internal.policy.impl.PhoneLayoutInflater.onCreateView(PhoneLayoutInflater.java:55) 
        at android.view.LayoutInflater.onCreateView(LayoutInflater.java:682) 
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:741) 
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:806) 
        at android.view.LayoutInflater.inflate(LayoutInflater.java:504) 
        at android.view.LayoutInflater.inflate(LayoutInflater.java:414) 
        at com.example.crashtest.webviewcrash.ui.main.MainFragment.onCreateView(MainFragment.java:28) 
        at androidx.fragment.app.Fragment.performCreateView(Fragment.java:2600) 
        at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:881) 
        at androidx.fragment.app.FragmentManagerImpl.moveFragmentToExpectedState(FragmentManagerImpl.java:1238) 
        at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:1303) 
        at androidx.fragment.app.FragmentManagerImpl.dispatchStateChange(FragmentManagerImpl.java:2659) 
        at androidx.fragment.app.FragmentManagerImpl.dispatchActivityCreated(FragmentManagerImpl.java:2613) 
        at androidx.fragment.app.FragmentController.dispatchActivityCreated(FragmentController.java:246) 
        at androidx.fragment.app.FragmentActivity.onStart(FragmentActivity.java:542) 
        at androidx.appcompat.app.AppCompatActivity.onStart(AppCompatActivity.java:201) 
        at android.app.Instrumentation.callActivityOnStart(Instrumentation.java:1220) 
        at android.app.Activity.performStart(Activity.java:5953) 
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2261) 
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2360) 
        at android.app.ActivityThread.access$800(ActivityThread.java:144) 
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1278) 
        at android.os.Handler.dispatchMessage(Handler.java:102) 
        at android.os.Looper.loop(Looper.java:135) 
        at android.app.ActivityThread.main(ActivityThread.java:5221) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at java.lang.reflect.Method.invoke(Method.java:372) 
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:899) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:694) 
     Caused by: android.content.res.Resources$NotFoundException: String resource ID #0x2040002
        at android.content.res.Resources.getText(Resources.java:274)
        at android.content.res.Resources.getString(Resources.java:360)
        at com.android.org.chromium.content.browser.ContentViewCore.setContainerView(ContentViewCore.java:702)
        at com.android.org.chromium.content.browser.ContentViewCore.initialize(ContentViewCore.java:608)
        at com.android.org.chromium.android_webview.AwContents.createAndInitializeContentViewCore(AwContents.java:619)
        at com.android.org.chromium.android_webview.AwContents.setNewAwContents(AwContents.java:758)
        at com.android.org.chromium.android_webview.AwContents.<init>(AwContents.java:608)
        at com.android.org.chromium.android_webview.AwContents.<init>(AwContents.java:546)
        at com.android.webview.chromium.WebViewChromium.initForReal(WebViewChromium.java:312)
        at com.android.webview.chromium.WebViewChromium.access$100(WebViewChromium.java:97)
    	at com.android.webview.chromiu
```

## Android 6.0 (API 23)

App crashes when tapping the `<select>`:

```
10-04 09:20:30.044 3844-3844/com.example.crashtest.webviewcrash W/ResourceType: Invalid package identifier when getting bag for resource number 0x02060000
10-04 09:20:30.055 3844-3844/com.example.crashtest.webviewcrash W/ResourceType: No package identifier when getting value for resource number 0x00000000
10-04 09:20:30.055 3844-3844/com.example.crashtest.webviewcrash D/AndroidRuntime: Shutting down VM
10-04 09:20:30.055 3844-3844/com.example.crashtest.webviewcrash E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.crashtest.webviewcrash, PID: 3844
    android.content.res.Resources$NotFoundException: Resource ID #0x0
        at android.content.res.Resources.getValue(Resources.java:1351)
        at android.content.res.Resources.loadXmlResourceParser(Resources.java:2774)
        at android.content.res.Resources.getLayout(Resources.java:1165)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:421)
        at android.widget.ArrayAdapter.createViewFromResource(ArrayAdapter.java:378)
        at android.widget.ArrayAdapter.getView(ArrayAdapter.java:369)
        at org.chromium.content.browser.input.SelectPopupAdapter.getView(SelectPopupAdapter.java:56)
        at android.widget.AbsListView.obtainView(AbsListView.java:2346)
        at android.widget.ListView.measureHeightOfChildren(ListView.java:1280)
        at android.widget.ListView.onMeasure(ListView.java:1188)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
        at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
        at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
        at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
        at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
        at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
        at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
        at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
        at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
        at com.android.internal.policy.PhoneWindow$DecorView.onMeasure(PhoneWindow.java:2643)
        at android.view.View.measure(View.java:18788)
        at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2100)
        at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:1191)
        at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1452)
        at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
        at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
        at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
        at android.view.Choreographer.doCallbacks(Choreographer.java:670)
        at android.view.Choreographer.doFrame(Choreographer.java:606)
        at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
        at android.os.Handler.handleCallback(Handler.java:739)
        at android.os.Handler.dispatchMessage(Handler.java:95)
        at android.os.Looper.loop(Looper.java:148)
        at android.app.ActivityThread.main(ActivityThread.java:5417)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
10-04 09:20:30.056 1785-3073/system_process W/ActivityManager:   Force finishing activity com.example.crashtest.webviewcrash/.MainActivity
```
