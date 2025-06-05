package net.gambla.keywords

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Inlay
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiKeyword

class FinalKeywordAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiKeyword && "final" == element.text) {
            val project = element.project

            ApplicationManager.getApplication().invokeLater {
                val editor = FileEditorManager.getInstance(project).selectedTextEditor
                if (editor == null) return@invokeLater

                val inlayModel = editor.inlayModel
                val range = element.textRange
                val offset = range.startOffset

                val alreadyExists = inlayModel.getInlineElementsInRange(offset, offset + 5)
                    .stream()
                    .anyMatch { inlay: Inlay<*>? -> inlay!!.getRenderer() is FinalInlayRenderer }

                if (!alreadyExists) {
                    inlayModel.addInlineElement<FinalInlayRenderer?>(offset, true, FinalInlayRenderer())
                }
            }
        }
    }
}
