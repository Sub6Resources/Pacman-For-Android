package com.sub6resources.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;


/**
 * Copyright (c) 2017 Matthew Whitaker.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
        private SurfaceHolder holder;

        private MyThread myThread;

        private GameController gameController;

        private Paint paint;

        private int width;
        private int height;

        public GameView(Context context, AttributeSet attributeSet) {
            super(context);
        }
        public GameView(Context context, GameController gameController, int width, int height)
        {
            super(context);
            holder = getHolder();

            holder.addCallback(this);

            this.gameController = gameController;
            this.width = width;
            this.height = height;
            paint = new Paint();
            //initialize paint object parameters
            paint.setColor(Color.WHITE);
            setWillNotDraw(false); //this line is very important!
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder)
        {
        }

        @Override
        // This is always called at least once, after surfaceCreated
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
        {
            if (myThread == null)
            {
                myThread = new MyThread(holder, gameController);
                myThread.setRunning(true);
                myThread.start();
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder)
        {
            boolean retry = true;
            myThread.setRunning(false);
            while (retry)
            {
                try
                {
                    myThread.join();
                    retry = false;
                }
                catch (InterruptedException e)
                {
                    Log.d(getClass().getSimpleName(), "Interrupted Exception", e);
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            System.out.println(event.getX() + " " + event.getY());
            gameController.onTouchEvent(event); //handle user interaction
            return super.onTouchEvent(event);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            canvas.drawText("Hello world!", width/20, 20, paint);
            gameController.draw(canvas);
        }

        public Thread getThread()
        {
            return myThread; // was 'return thread;'
        }

        public class MyThread extends Thread
        {
            private SurfaceHolder holder;
            private boolean running = false;

            private GameController gameController;

            public MyThread(SurfaceHolder holder, GameController gameController)
            {
                this.holder = holder;
                this.gameController = gameController;
            }

            @Override
            public void run()
            {
                Canvas canvas = null;
                while (running)
                {
                    gameController.update(); //update the time between last update() call and now
                    try
                    {
                        canvas = holder.lockCanvas(null);
                        synchronized (holder)
                        {
                            postInvalidate();
                        }
                    }
                    finally
                    {
                        if (canvas != null)
                        {
                            holder.unlockCanvasAndPost(canvas);
                        }
                    }
                }

            }

            public void setRunning(boolean b)
            {
                running = b;
            }
        }
    }
