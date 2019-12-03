package com.example.demo;

import com.example.dao.DbData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class AsyncService {

    @Autowired
    private final ApplicationEventPublisher mPublisher;
    private final ScheduledExecutorService executor =
            Executors.newSingleThreadScheduledExecutor();

    public AsyncService(ApplicationEventPublisher publisher) {
        this.mPublisher = publisher;
    }

    public void startProcessing(final String id) {
        final AsyncTask task = new AsyncTask(id, mPublisher, false);
        final AsyncTask complete = new AsyncTask(id, mPublisher, true);
        this.executor.schedule(task, 3, SECONDS);
        executor.schedule(task, 6, SECONDS);
        executor.schedule(task, 9, SECONDS);
        executor.schedule(complete, 11, SECONDS);
    }

    private static class AsyncTask implements Callable {
        private final String mId;
        private ApplicationEventPublisher mPublisher;
        private final Random rnd = new Random();
        private final boolean isComplete;
        public AsyncTask(final String id,
                         final ApplicationEventPublisher publisher, boolean isComplete) {
          mId = id;
          mPublisher = publisher;
          this.isComplete = isComplete;
        }

        public Object call() throws Exception {
            double random = rnd.nextInt(5000);
            mPublisher.publishEvent(new DbData(mId, isComplete? "Complete" : "event" + random));
            return "Called!";
        }
    }

}
