@file:JvmName("Lwjgl3Launcher")

package com.vbm.game.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.vbm.game.MyGame

fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return

    Lwjgl3Application(MyGame(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("RpgGame01")
        setForegroundFPS(60)
        setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode())
        useVsync(false)
    })
}
