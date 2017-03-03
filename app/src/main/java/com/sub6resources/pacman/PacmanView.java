package com.sub6resources.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.sub6resources.game.GameController;
import com.sub6resources.game.GameView;

/**
 * Created by Matthew Whitaker on 2/21/2017.
 */

public class PacmanView extends GameView
{
    public PacmanView(Context context, AttributeSet attributeSet) {
        super(context, new GameController(), 100, 100);
    }
    public PacmanView(Context context, GameController gameController, int width, int height) {
        super(context, gameController, width, height);
    }
}
