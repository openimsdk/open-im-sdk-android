package io.openim.android.sdk.internal.schedule;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.openim.android.sdk.util.Predicates;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public final class Schedulers {

    private static final String IO_THREAD_NAME_PREFIX = "OpenImIoThread";
    private static final String COMPUTATION_THREAD_NAME_PREFIX = "OpenImComputationThread";

    @NonNull
    private static final Schedulers INSTANCE;

    private final Handler mainHandler;
    private final ExecutorService ioExecutor;
    private final ExecutorService computingExecutor;

    private Schedulers() {
        mainHandler = new Handler(Looper.getMainLooper());
        ioExecutor = new ThreadPoolExecutor(1, 16, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(16), new OpenImThreadFactory(IO_THREAD_NAME_PREFIX));
        computingExecutor = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            16,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(16),
            new OpenImThreadFactory(COMPUTATION_THREAD_NAME_PREFIX)
        );
    }

    static {
        INSTANCE = new Schedulers();
    }

    @NonNull
    public static Schedulers getInstance() {
        return INSTANCE;
    }

    public static void runOnMainThread(@NonNull Runnable runnable) {
        Predicates.requireNonNull(runnable);

        INSTANCE.mainHandler.post(runnable);
    }

    public static void scheduleIO(@NonNull Runnable runnable) {
        Predicates.requireNonNull(runnable);

        INSTANCE.ioExecutor.execute(runnable);
    }

    public static <T> Future<T> scheduleIO(@NonNull Callable<T> task) {
        Predicates.requireNonNull(task);

        return INSTANCE.ioExecutor.submit(task);
    }

    public static void scheduleComputation(@NonNull Runnable runnable) {
        Predicates.requireNonNull(runnable);

        INSTANCE.computingExecutor.execute(runnable);
    }

    public static <T> Future<T> scheduleComputation(@NonNull Callable<T> task) {
        Predicates.requireNonNull(task);

        return INSTANCE.computingExecutor.submit(task);
    }
}
