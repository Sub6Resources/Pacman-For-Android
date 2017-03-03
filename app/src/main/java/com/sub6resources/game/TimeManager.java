package com.sub6resources.game;

/**
 * Copyright (c) 2017 Matthew Whitaker.
 */

class TimeManager {
    private long oldTime;

    public TimeManager() {
        this.oldTime = 0L;
    }

    public TimeManager getTimeManager() {
        return this;
    }

    public long getDeltaTime(long currentTimeMillis) {
        long temp = currentTimeMillis - oldTime;
        this.oldTime = currentTimeMillis;
        return temp;
    }

}
