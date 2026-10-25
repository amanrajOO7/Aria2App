# ProGuard rules for Aria2App

# Keep serializable model classes
-keepnames class * implements java.io.Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep Aria2 JSON-RPC Models & Profiles
-keep class com.gianlu.aria2app.api.aria2.** { *; }
-keep class com.gianlu.aria2app.profiles.** { *; }

# JSch (mwiede)
-keep class com.jcraft.jsch.** { *; }
-dontwarn com.jcraft.jsch.**

# SMBJ
-keep class com.hierynomus.** { *; }
-dontwarn com.hierynomus.**

# OkHttp & Okio
-dontwarn okhttp3.**
-dontwarn okio.**
-keepattributes Signature
-keepattributes *Annotation*

# Jetpack Compose
-keepclassmembers class * extends androidx.compose.ui.Modifier { *; }
