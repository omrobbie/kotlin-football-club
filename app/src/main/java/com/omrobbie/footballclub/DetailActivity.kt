package com.omrobbie.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)
    }

    inner class DetailActivityUI: AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)

                textView {
                    setText("This is detail activity")
                }
            }
        }
    }
}
