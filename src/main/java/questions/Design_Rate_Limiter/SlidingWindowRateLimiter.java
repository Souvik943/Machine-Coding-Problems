package questions.Design_Rate_Limiter;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowRateLimiter {
    long windowSize = 1000L;
    long allowedBucketSize;
    Deque<Long> requestQueue;

    public SlidingWindowRateLimiter(long allowedBucketSize) {
        this.allowedBucketSize = allowedBucketSize;
        requestQueue = new ConcurrentLinkedDeque<>();
    }

    public synchronized boolean isRequestAllowed() {
        long currentTime = System.currentTimeMillis()/1000;
        while(!requestQueue.isEmpty() && (requestQueue.peek() - currentTime) > windowSize) {
            requestQueue.poll();
        }

        if(requestQueue.size() < allowedBucketSize) {
            requestQueue.offer(currentTime);
            return true;
        }
        return false;
    }
}
