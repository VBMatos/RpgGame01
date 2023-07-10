package com.vbm.game

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.vbm.game.screen.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

class MyGame : KtxGame<KtxScreen>(){

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        addScreen(GameScreen())
        setScreen<GameScreen>()
    }
}
