package org.jetbrains.testplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import java.awt.Component

class TestAction3: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val currentProject: Project = e.project!!
        val selectedComponent: Component? = e.getData(PlatformDataKeys.CONTEXT_COMPONENT)
        val message: String = if (selectedComponent == null) {
            "No selected component is available"
        } else {
            val type: Class<Component> = selectedComponent.javaClass
            if (type.isAnonymousClass) {
                type.enclosingClass.simpleName
            } else {
                type.simpleName
            }
        }
        Messages.showMessageDialog(
                currentProject,
                message,
                "Selected Component",
                Messages.getInformationIcon())
    }
}