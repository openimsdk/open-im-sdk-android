//package io.openim.android.sdk.internal.tools;
//
//import android.os.Handler;
//import android.os.Looper;
//
//import androidx.annotation.NonNull;
//
//import io.openim.android.sdk.util.Predicates;
//
///**
// * Created by alvince on 2021/9/24
// *
// * @author alvince.zy@gmail.com
// */
//public class Schedulers {
//
//    private static class SingletonHolder {
//        private static final Schedulers INSTANCE = new Schedulers();
//    }
//
//    private final Handler mainHandler;
//
//    private Schedulers() {
//        mainHandler = new Handler(Looper.getMainLooper());
//    }
//
//    public static Schedulers getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//    public static void runOnMainThread(@NonNull Runnable runnable) {
//        Predicates.requireNonNull(runnable);
//
//        getInstance().mainHandler.post(runnable);
//    }
//}
