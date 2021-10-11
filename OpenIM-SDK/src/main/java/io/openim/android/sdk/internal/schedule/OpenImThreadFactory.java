package io.openim.android.sdk.internal.schedule;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A ThreadFactory that counts how many threads have been created and given a prefix, sets the created Thread's name to prefix-count.
 * <p/>
 * Created by alvince on 2021/9/30
 *
 * @author alvince.zy@gmail.com
 */
final class OpenImThreadFactory extends AtomicLong implements ThreadFactory {

    final String prefix;

    final int priority;

    public OpenImThreadFactory(String prefix) {
        this(prefix, Thread.NORM_PRIORITY);
    }

    public OpenImThreadFactory(String prefix, int priority) {
        this.prefix = prefix;
        this.priority = priority;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = prefix + '-' + incrementAndGet();
        Thread t = new Thread(r, name);
        t.setPriority(priority);
        t.setDaemon(true);
        return t;
    }

    @Override
    public String toString() {
        return "OpenImThreadFactory[" + prefix + "]";
    }
}
