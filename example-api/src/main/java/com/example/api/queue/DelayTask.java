/*
package com.example.api.queue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayTask implements Delayed {
    private static long currentTime = System.currentTimeMillis();
    protected final String taskName;
    protected final int timeCost;
    protected final long scheduleTime;

    protected static final AtomicInteger taskCount = new AtomicInteger(0);

    public DelayTask(String taskName, int timeCost) {
        this.taskName = taskName;
        this.timeCost = timeCost;
        taskCount.incrementAndGet();
        currentTime += 1000 + Math.random() * 1000;
        scheduleTime = currentTime;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long expirationTime = scheduleTime - System.currentTimeMillis();
        return unit.convert(expirationTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        Callable callable = () -> {
            System.out.println("Execute Thread");
            return null;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future submit = executorService.submit(callable);
        Object o = null;
        try {
            o = submit.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return (int) (this.scheduleTime - ((DelayTask) o).scheduleTime);
    }
}
*/
