package com.omrobbie.footballclub

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)
    }

    inner class DetailActivityUI : AnkoComponent<DetailActivity> {
        val id_view = 1
        val id_image = 2
        val id_name = 3

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, wrapContent)

                view {
                    id = id_view
                    setBackgroundColor(Color.rgb(126, 203, 238))
                }.lparams(matchParent, dip(200))

                imageView {
                    id = id_image
                    Glide.with(this)
                            .load(android.R.drawable.ic_delete)
                            .into(this)
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(150)
                }

                textView {
                    id = id_name
                    text = "Football Club FC"
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(id_image)
                    centerHorizontally()
                }

                textView {
                    padding = dip(16)
                    text = "Description"
                }.lparams {
                    below(id_name)
                }
            }
        }
    }
}
