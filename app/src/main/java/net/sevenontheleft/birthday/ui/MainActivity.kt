package net.sevenontheleft.birthday.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import net.sevenontheleft.birthday.R
import net.sevenontheleft.birthday.engine.BirthdayRepo
import net.sevenontheleft.birthday.model.Birthday
import net.sevenontheleft.birthday.model.BirthdayViewModel
import net.sevenontheleft.birthday.model.BirthdayViewModelFactory
import org.w3c.dom.Text
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    private lateinit var model: BirthdayViewModel
    private lateinit var adapter: BirthdayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = BirthdayAdapter()
        list_view.layoutManager = LinearLayoutManager(this)
        list_view.adapter = adapter
        list_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val birthdayRepo = BirthdayRepo(this)
        model = ViewModelProvider(this, BirthdayViewModelFactory(birthdayRepo)).get(BirthdayViewModel::class.java)
        model.birthdayList.observe(this, { birthdayList ->
            birthdayList?.let {
                adapter.setBirthdayList(birthdayList)
            }
        })
    }

    inner class BirthdayAdapter() : RecyclerView.Adapter<BirthdayHolder>() {
        private var birthdayList = emptyList<Birthday>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayHolder {
            val inflater = LayoutInflater.from(parent.context)
            return BirthdayHolder(inflater, parent)
        }

        override fun onBindViewHolder(holder: BirthdayHolder, position: Int) {
            holder.bind(birthdayList[position])
        }

        override fun getItemCount(): Int {
            return birthdayList.size
        }

        fun setBirthdayList(birthdayList: List<Birthday>) {
            this.birthdayList = birthdayList
            notifyDataSetChanged()
        }
    }

    inner class BirthdayHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_birthday, parent, false)) {

        fun bind(birthday : Birthday) {
            itemView.findViewById<TextView>(R.id.name).text = birthday.name?.first
            // we need to format the date to show it
            itemView.findViewById<TextView>(R.id.date).text = SimpleDateFormat("dd-MM-yyyy").format(birthday.dob?.date).toString()
        }
    }
}