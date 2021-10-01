package com.example.kotlintest

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentKotlin : Fragment() {
    private var list: ArrayList<Card> = ArrayList(16)
    private var adapterRecycler = Adapter(list, this)

    private var position: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0..40) {
            list.add(Card("TextKotlin", i))
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapterRecycler
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val menuInflater = requireActivity().menuInflater
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.optionsContext1) {
            adapterRecycler.notifyItemRemoved(position)
        }
        if (item.itemId == R.id.optionsContext2) {
            Toast.makeText(requireContext(), "ContextMenu2", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    fun remove(card: Card) {
        for (i in 0 until list.size) {
            if (list[i] == card) {
                list.removeAt(i)
                this.position = i
                break
            }
        }
    }

}
