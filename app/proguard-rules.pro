# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# SwipeBackLayout
#-dontwarn com.wonium.cicada.android.ui.weight.**
#-keep class com.wonium.cicada.android.ui.weight.**{*;}
#-keep class com.wonium.cicada.android.ui.weight.SwipeBackLayout{*;}
##-keep class com.wonium.cicada.android.ui.weight.SwipeBackLayout.DragEdge{*;}
#-keep enum com.wonium.cicada.android.ui.weight.SwipeBackLayout$DragEdge{*;}
#-keep  class com.wonium.cicada.android.ui.weight.SwipeBackLayout$ * {
# *;
#}
##-keepclassmembers enum * {
##    *;
##}
##-keepclassmembers class com.wonium.cicada.android.ui.weight.SwipeBackLayout{
##    public void test(com.wonium.cicada.android.ui.weight.SwipeBackLayout$DragEdge);
##}
-dontwarn org.**
-dontwarn com.**
-dontwarn afu.**

# 忽略警告


-dontnote android.widget.Space
-dontnote com.wonium.cicada.**
-dontnote com.alibaba.android.**

# 保持所有databinding类
-dontwarn androidx.databinding.**
-dontnote androidx.databinding.**
-dontnote android.databinding.**
-keep class androidx.databinding.** { *; }
-keep class androidx.annotation.**{*;}

# ARouter start
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}

# If you use the byType method to obtain Service, add the following rules to protect the interface:
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider

# If single-type injection is used, that is, no interface is defined to implement IProvider, the following rules need to be added to protect the implementation
-keep class * implements com.alibaba.android.arouter.facade.template.IProvider
# ARouter end
#-keep public class com.google.android.material.**{*;}

-keep class com.google.android.material.**