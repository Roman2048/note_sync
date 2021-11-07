package net.longday.netnote

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class NetNoteApp : Application() {

    override fun start(stage: Stage) {
        stage.isResizable = false
        val fxmlLoader = FXMLLoader(NetNoteApp::class.java.getResource("main.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Netnote"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(NetNoteApp::class.java)
}