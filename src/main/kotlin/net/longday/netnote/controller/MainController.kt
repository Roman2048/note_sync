package net.longday.netnote.controller

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import net.longday.netnote.model.Settings
import net.longday.netnote.service.SettingsService
import net.longday.netnote.service.SynchronizerService

class MainController {

    @FXML
    private lateinit var filePathLabel: Label

    @FXML
    private lateinit var filePathTextField: TextField

    @FXML
    private fun onSaveButtonClick() {
        SettingsService.updateSettings(Settings(filePathTextField.text))
    }

    init {
        refreshTextField()
        SynchronizerService
    }

    fun onRefreshButtonClick() {
        refreshTextField()
    }

    private fun refreshTextField() {
        Platform.runLater { filePathTextField.text = SettingsService.getSettings().filePathToSync }
    }
}