package com.sub6resources.pacman;

import android.graphics.*;

import com.sub6resources.game.GameController;
import com.sub6resources.game.TimeManager;

/**
 * Copyright 2017 Matthew Whitaker
 */

public class Man {
    //Variables
    Point location = new Point(100,100);
    Bitmap texture;
    GameController game;
    TimeManager timeManager;

    public Man() {}
    public Man(Bitmap _texture, GameController _game, TimeManager _timeManager) {
        texture=_texture;
        game = _game;
        timeManager = _timeManager;
    }
}
