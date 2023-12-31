package com.vbm.game.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.github.quillraven.fleks.World
import com.vbm.game.component.ImageComponent
import com.vbm.game.component.ImageComponent.Companion.ImageComponentListener
import com.vbm.game.system.RenderSystem
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.log.logger

class GameScreen : KtxScreen{

    private val stage : Stage = Stage(ExtendViewport(16f, 9f))
    private val texture : Texture = Texture("graphics/player.png")
    private val world : World = World{
        inject(stage)
        componentListener<ImageComponentListener>()
        system<RenderSystem>()
    }

    override fun show() {
        world.entity{
            add<ImageComponent>{
                image = Image(texture).apply {
                    setSize(4f, 4f)
                }
            }
        }
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        world.update(delta)
    }

    override fun dispose() {
        stage.disposeSafely()
        texture.disposeSafely()
        world.dispose()
    }

    companion object{
        private val log = logger<GameScreen>()
    }
}
