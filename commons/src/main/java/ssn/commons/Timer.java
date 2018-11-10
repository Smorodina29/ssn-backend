package ssn.commons;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Simple timer for supporting some c# timer operations.
 *
 * @author Aleksandr Petukhov
 */
public class Timer {
    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    private Runnable task;

    private long delay;

    private ScheduledFuture future;

    /**
     * create timer with particular task and delay values
     * @param delay delay in milliseconds
     * @param task runnable task
     */
    public Timer(long delay, Runnable task){
        this.task = task;
        this.delay = delay;
    }

    /**
     * Start timer to execute task every <i>delay</i> milliseconds.
     *
     * This method change the state of this timer to enabled.
     */
    public void start(){
        future = executor.scheduleAtFixedRate(task, delay, delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Stop executing timer at fixed rate and change its state to cancelled.
     *
     * This method may be called repeatedly. the second and subsequent calls have no effect.
     */
    public void stop(){
        future.cancel(false);
    }

    /**
     * Check whether state of this timer is enabled or not
     * @return true if and only if this timer was already scheduled for the first time
     *         and its state is not cancelled
     */
    public boolean isEnabled(){
        return future != null && !future.isCancelled();
    }

    /**
     * Set delay and reload timer
     * @param delay delay to be set
     */
    public void setDelay(long delay){
        stop();
        this.delay = delay;
        start();
    }
}
