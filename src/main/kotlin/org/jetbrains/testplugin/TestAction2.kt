package org.jetbrains.testplugin

import com.intellij.codeInsight.daemon.impl.DaemonCodeAnalyzerImpl
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class TestAction2: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val title = "Gutter Icons"
        val currentProject: Project = e.project!!
        val currentFiles: Array<VirtualFile> = FileEditorManager.getInstance(currentProject).selectedFiles
        if (currentFiles.isNotEmpty()) {
            val currentFile: VirtualFile = currentFiles.first()
            val document: Document = FileDocumentManager.getInstance().getDocument(currentFile)!!
            val icons: List<Icon> = DaemonCodeAnalyzerImpl.getLineMarkers(document, currentProject).map { it.icon }

            if (icons.isNotEmpty()) {
                val dialog = IconsDialog(currentProject, title, icons)
                dialog.show()
            } else {
                Messages.showMessageDialog(
                        currentProject,
                        "No gutter icons are displayed in the current file",
                        title,
                        Messages.getInformationIcon())
            }
        } else {
            Messages.showMessageDialog(
                    currentProject,
                    "No opened file found",
                    title,
                    Messages.getWarningIcon())
        }
    }
}