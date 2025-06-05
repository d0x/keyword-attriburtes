package net.gambla.keywords

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiKeyword
import com.intellij.ui.Gray
import java.awt.Color
import java.awt.Font


class KeywordAnnotator : Annotator {

    val defaultAttributes = TextAttributes(Color(120, 120, 120, 150), null, null, null, Font.PLAIN)
    val CUSTOM_KEY = TextAttributesKey.createTextAttributesKey(
        "CUSTOM_KEYWORD",
        defaultAttributes
    )

    val uselessKeywords = setOf("final", "this")

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiKeyword) {
            if (uselessKeywords.contains(element.text)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(CUSTOM_KEY)
                    .create()
            }
        }
    }
}
