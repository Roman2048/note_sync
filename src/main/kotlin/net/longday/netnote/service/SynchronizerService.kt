package net.longday.netnote.service

import kotlinx.coroutines.*
import net.longday.netnote.http.HttpClient
import java.io.File
import java.nio.file.FileSystems
import java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY
import java.nio.file.WatchService

object SynchronizerService {

    private val FileToSync = File(SettingsService.getSettings().filePathToSync)
    private val watchService: WatchService = FileSystems.getDefault().newWatchService()

    private fun creteChangeWatcher(): Job {
        val watchKey = FileToSync.parentFile.toPath().register(watchService, ENTRY_MODIFY)
        return CoroutineScope(Dispatchers.IO).launch {
            while (this.isActive) {
                if (watchKey.pollEvents().isNotEmpty()) {
                    sync()
                }
                delay(1000L)
            }
        }
    }

    private fun sync() {
        val sb = StringBuilder()
        FileToSync.forEachLine { sb.appendLine(it) }
        HttpClient.send(sb.toString())
    }

    init {
        creteChangeWatcher()
    }
}