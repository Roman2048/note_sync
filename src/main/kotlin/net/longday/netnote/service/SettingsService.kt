package net.longday.netnote.service

import net.longday.netnote.model.Settings
import net.longday.netnote.repository.SettingsRepository
import net.longday.netnote.repository.SettingsRepositoryImpl

object SettingsService {

    private val settingsRepository: SettingsRepository

    fun getSettings(): Settings {
        return settingsRepository.getSettings()
    }

    fun updateSettings(settings: Settings) {
        settingsRepository.updateSettings(settings)
    }

    init {
        settingsRepository = SettingsRepositoryImpl()
    }
}