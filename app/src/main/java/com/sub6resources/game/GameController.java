package com.sub6resources.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Copyright (c) 2017 Matthew Whitaker.
 */

public class GameController {
    TimeManager timeManager = new TimeManager();
    boolean isGameOver;

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void draw(Canvas canvas) {

    }

    public void update() {
        long delta = getTimeManager().getDeltaTime(System.currentTimeMillis());
        long timeChunk;
        if (isGameOver == false) {
            for (long i = 0; i < delta; i += 20) {
                long iNext = i + 20;
                if (iNext > delta) {
                    timeChunk = delta - i;
                } else {
                    timeChunk = iNext - i;
                }
                // ...update game entities based on the miliseconds provided in timeChunk
            }
        }
    }
    public TimeManager getTimeManager() {
        return this.timeManager;
    }
}


