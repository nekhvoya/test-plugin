package org.jetbrains.testplugin

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBScrollPane
import org.jetbrains.annotations.NotNull
import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.*


class IconsDialog(@NotNull project: Project, @NotNull title: String, icons: List<Icon>) : DialogWrapper(project) {
    private val icons: List<Icon>

    init {
        this.icons = icons
        isResizable = false
        setTitle(title)

        init()
    }

    override fun createActions(): Array<Action> {
        return arrayOf(okAction)
    }

    override fun createCenterPanel(): JComponent {
        val gap = 3
        val maxColumns = 15
        val maxRows = 2

        val layout = GridLayout(0, maxColumns, gap, gap)
        val dialogPanel = JPanel(layout)

        val scrollPane = JBScrollPane(dialogPanel)
        scrollPane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
        scrollPane.horizontalScrollBarPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        scrollPane.border = BorderFactory.createEmptyBorder()

       if (icons.isNotEmpty()) {
            val icon: Icon = icons.first()
            val panelWidth = (icon.iconWidth + gap) * maxColumns
            val panelHeight = (icon.iconHeight + gap) * maxRows
            scrollPane.preferredSize = Dimension(panelWidth, panelHeight)
            icons.stream().map { i: Icon -> JLabel(i) }.forEach { comp: JLabel -> dialogPanel.add(comp) }
        }

        return scrollPane
    }
}
