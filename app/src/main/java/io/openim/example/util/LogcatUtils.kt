/*
 * Created by alvince on 2021/10/11
 *
 * @author alvince.zy@gmail.com
 */

package io.openim.example.util

import android.util.Log

const val TAG = "OpenIM-Sample"

inline fun logD(tag: String = TAG, supplier: () -> String) {
    supplier().takeIf { it.isNotEmpty() }
        ?.also {
            Log.d(tag, it)
        }
}

inline fun logI(tag: String = TAG, supplier: () -> String) {
    supplier().takeIf { it.isNotEmpty() }
        ?.also {
            Log.i(tag, it)
        }
}

inline fun logE(tag: String = TAG, throwable: Throwable? = null, supplier: () -> String) {
    val message = supplier()
    throwable?.also { Log.e(tag, message, it) } ?: Log.e(TAG, message)
}
