package com.omrobbie.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var items: MutableList<ItemData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadDummy()
        MainActivityUI(items).setContentView(this)
    }

    inner class MainActivityUI(val items: List<ItemData>): AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)
                padding = dip(16)

                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    adapter = ClubAdapter(items)
                }
            }
        }
    }

    fun loadDummy() {
        items.clear()

        for (i in 1..5) {
            items.add(ItemData(android.R.drawable.ic_delete, "Club $i"))
        }
    }
}
