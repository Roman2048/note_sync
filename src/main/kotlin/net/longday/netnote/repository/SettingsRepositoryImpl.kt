package net.longday.netnote.repository

import com.google.gson.Gson
import net.longday.netnote.model.Settings
import java.io.File

class SettingsRepositoryImpl : SettingsRepository {

    private val settingsFolderPath = "${System.getProperty("user.home")}\\.netnote"
    private val settingsFilePath = "$settingsFolderPath\\settings.json"

    override fun getSettings(): Settings {
        val settingsFolder = File(settingsFolderPath)
        if (!settingsFolder.exists()) {
            settingsFolder.mkdir()
        }
        val settingsFile = File(settingsFilePath)
        // Create the settings.json if it isn't exist. Read if existed.
        if (!settingsFile.createNewFile()) {
            val sb = StringBuilder()
            settingsFile.forEachLine { sb.append(it) }
            return Gson().fromJson(sb.toString(), Settings::class.java)
        }
        throw RuntimeException("Can't read $settingsFilePath")
    }

    override fun updateSettings(settings: Settings) {
        File("${System.getProperty("user.home")}\\.netnote\\settings.json").writeText(Gson().toJson(settings))
    }
}