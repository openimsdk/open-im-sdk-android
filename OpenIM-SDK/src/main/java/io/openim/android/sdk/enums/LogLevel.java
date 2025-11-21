package io.openim.android.sdk.enums;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IntDef(value = {
    LogLevel.Fatal,
    LogLevel.Panic,
    LogLevel.Error,
    LogLevel.Warn,
    LogLevel.Info,
    LogLevel.Debug,
    LogLevel.DebugWithSQL
})
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface LogLevel {
    int Fatal = 0;
    int Panic = 1;
    int Error = 2;
    int Warn = 3;
    int Info = 4;
    int Debug = 5;
    int DebugWithSQL = 6;
}
