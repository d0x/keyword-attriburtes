package net.gambla.keywords

import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.EditorCustomElementRenderer
import com.intellij.openapi.editor.Inlay
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.util.IconLoader.getIcon
import java.awt.Graphics
import java.awt.Rectangle

class FinalInlayRenderer : EditorCustomElementRenderer {
    override fun calcWidthInPixels(inlay: Inlay<*>): Int {
        return ICON.iconWidth
    }

    override fun paint(
        inlay: Inlay<*>, g: Graphics,
        targetRegion: Rectangle, textAttributes: TextAttributes
    ) {
        ICON.paintIcon(null, g, targetRegion.x, targetRegion.y)
    }

    companion object {
//                private val ICON = getIcon("/icons/final.svg", FinalInlayRenderer::class.java)
        private val ICON = AllIcons.Nodes.FinalMark
    }
}
