package com.omrobbie.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        const val PARCELABLE_ITEM_DATA = "ItemData"
    }

    var items: MutableList<ItemData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()
        MainActivityUI(items).setContentView(this)
    }

    inner class MainActivityUI(val items: List<ItemData>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)

                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context, 1))
                    adapter = ClubAdapter(items) {
                        startActivity<DetailActivity>(PARCELABLE_ITEM_DATA to it)
                    }
                }
            }
        }
    }

    fun loadData() {
        val image = resources.obtainTypedArray(R.array.club_image)
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)

        items.clear()

        for (i in name.indices) {
            items.add(ItemData(image.getResourceId(i, 0), name[i], desc[i]))
        }

        image.recycle()
    }
}
