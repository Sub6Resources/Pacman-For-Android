package com.sub6resources.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Copyright (c) 2017 Matthew Whitaker.
 */

public class GameController {
    TimeManager timeManager = new TimeManager();
    boolean isGameOver;
    Paint paint = new Paint();

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void draw(Canvas canvas) {
        paint.setColor(Color.YELLOW);
        canvas.drawText("It works!", canvas.getWidth()/20, 20, paint);
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


