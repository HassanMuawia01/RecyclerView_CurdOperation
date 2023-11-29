package com.example.recyclerviewactivity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataArrayList: ArrayList<DataClass>
    private lateinit var binding: ActivityMainBinding
    lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addupdateBtn.setOnClickListener {
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.add_update)
            val edname=dialog.findViewById<EditText>(R.id.contactName)
            val edphone=dialog.findViewById<EditText>(R.id.ContactNumber)
            val AddData=dialog.findViewById<Button>(R.id.AUBtn)

            AddData.setOnClickListener {
                    var name: String? = edname.text.toString()
                    val phone=edphone.text.toString()

                if (name!!.isNotEmpty() && phone.isNotEmpty()) {
                    dataArrayList.add(DataClass(R.drawable.a, name, phone))
                    rvAdapter.notifyItemInserted(dataArrayList.size-1)
                    binding.rv.scrollToPosition(dataArrayList.size-1)
                }
                dialog.dismiss()
            }
                dialog.show()

        }
        // Initialize the ArrayList
        dataArrayList = ArrayList()

        dataArrayList.add(DataClass(R.drawable.a,"Zma Zargyee","92320057221"))
        dataArrayList.add(DataClass(R.drawable.b,"Hassan","923488213215"))
        dataArrayList.add(DataClass(R.drawable.c,"Muawia","923412312312"))
        dataArrayList.add(DataClass(R.drawable.d,"Home","92301233275"))
        dataArrayList.add(DataClass(R.drawable.f,"Home 2","92311329409"))
        dataArrayList.add(DataClass(R.drawable.g,"Asim","91231134321"))
        dataArrayList.add(DataClass(R.drawable.h,"Talha","93211313133"))
        dataArrayList.add(DataClass(R.drawable.i,"Sheri","92342154622"))
        dataArrayList.add(DataClass(R.drawable.j,"Shoiab","21313421313"))

// Set the layout manager for the RecyclerView
        binding.rv.layoutManager= LinearLayoutManager(this@MainActivity)

//    Create an adapter and set it for the RecyclerView

       rvAdapter=RvAdapter(this,dataArrayList)
        binding.rv.adapter=rvAdapter

    }
}