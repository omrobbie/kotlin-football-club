package com.omrobbie.footballclub

import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup> {

    companion object {
        val club_image = 1
        val club_name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL

            imageView {
                id = club_image
                layoutParams = LinearLayout.LayoutParams(50,50)
            }

            textView {
                id = club_name
                layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent)
            }
        }
    }
}