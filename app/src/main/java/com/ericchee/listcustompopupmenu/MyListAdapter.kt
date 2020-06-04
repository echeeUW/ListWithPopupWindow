package com.ericchee.listcustompopupmenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyListAdapter(
    private val context: Context
): RecyclerView.Adapter<MyListAdapter.ItemViewHolder>() {
    private val items: List<String> = """
        Rats breed so quickly that in just 18 months, 2 rats could have created over 1 million relatives.
        The blue whale can produce the loudest sound of any animal. At 188 decibels, the noise can be detected over 800 kilometres away.
        Horses and cows sleep while standing up.
        Giant Arctic jellyfish have tentacles that can reach over 36 metres in length.
        Locusts have leg muscles that are about 1000 times more powerful than an equal weight of human muscle.
        Hummingbirds are so agile and have such good control that they can fly backwards.
        Instead of bones, sharks have a skeleton made from cartilage.
        Insects such as bees, mosquitoes and cicadas make noise by rapidly moving their wings.
        The horn of a rhinoceros is made from compacted hair rather than bone or another substance.
        Sharks lay the biggest eggs in the world.
        Even when a snake has its eyes closed, it can still see through its eyelids.
        Unlike humans, sheep have four stomachs, each one helps them digest the food they eat.
        Despite the white, fluffy appearance of Polar Bears fur (which is transparent), it actually has black skin.
        As well as being a famous Looney Tunes character, the Tasmanian Devil is a real animal that is only found in the wild in Tasmania, Australia. It is the largest carnivorous marsupial in the world.
        The average housefly only lives for 2 or 3 weeks.
        Mosquitoes can be annoying insects but did you know that it's only the female mosquito that actually bites humans.
        Cats use their whiskers to check whether a space is too small for them to fit through or not.        
    """.trimIndent().lines()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tvName)
        private val btnEmoji = itemView.findViewById<ImageView>(R.id.btnEmoji)

        fun bind(item: String, position: Int) {
            tvName.text = item

            btnEmoji.setOnClickListener {
                createPopupWindow(position).showAsDropDown(btnEmoji)
            }
        }
    }

    private fun createPopupWindow(itemPosition: Int): PopupWindow {
        val popupMenuView = LayoutInflater.from(context).inflate(R.layout.emoji_selection_popup, null).apply {
            findViewById<ImageView>(R.id.btnHairFace).setOnClickListener {
                Toast.makeText(context, "Hair Emoji has been clicked for position: $itemPosition", Toast.LENGTH_SHORT).show()
            }
            findViewById<ImageView>(R.id.btnGroup).setOnClickListener {
                Toast.makeText(context, "Group Emoji has been clicked for position: $itemPosition", Toast.LENGTH_SHORT).show()
            }
            findViewById<ImageView>(R.id.btnSmiley).setOnClickListener {
                Toast.makeText(context, "Smiley Emoji has been clicked for position: $itemPosition", Toast.LENGTH_SHORT).show()
            }
        }

        return PopupWindow(popupMenuView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)



    }
}