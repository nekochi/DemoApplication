package com.nekomimi.demo

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Supplier
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.model.Statement
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.nekomimi.demo", appContext.packageName)


    }
}
class RxImmediateSchedulerRule : TestRule {
    private val immediate: Scheduler =
        object : Scheduler() {
            override fun scheduleDirect(
                run: Runnable,
                delay: Long,
                unit: TimeUnit
            ): Disposable {
                // this prevents StackOverflowErrors when scheduling with a delay
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(
                    Executor { obj: Runnable -> obj.run() },false,true
                )
            }
        }

    override fun apply(
        base: Statement,
        description: Description
    ): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setInitIoSchedulerHandler { scheduler: Supplier<Scheduler?>? -> immediate }
                RxJavaPlugins.setInitComputationSchedulerHandler { scheduler: Supplier<Scheduler?>? -> immediate }
                RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler: Supplier<Scheduler?>? -> immediate }
                RxJavaPlugins.setInitSingleSchedulerHandler { scheduler: Supplier<Scheduler?>? -> immediate }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }
}

