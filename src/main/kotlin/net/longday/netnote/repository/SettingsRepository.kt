package net.longday.netnote.repository

import net.longday.netnote.model.Settings

interface SettingsRepository {
    fun getSettings(): Settings
    fun updateSettings(settings: Settings)
}