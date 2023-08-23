package org.jetbrains.testplugin

import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class TestAction1: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val currentProject: Project = e.project!!

        val matchingPlugins: List<IdeaPluginDescriptor> = PluginManager.getLoadedPlugins()
                .filter { it.pluginId.idString == "org.jetbrains.kotlin" }
        val kotlinVersion: String = if (matchingPlugins.isEmpty()) "Kotlin plugin wasn't found" else matchingPlugins.first().version

        Messages.showMessageDialog(
                currentProject,
                kotlinVersion,
                "Kotlin Plugin Version",
                Messages.getInformationIcon())
    }
}