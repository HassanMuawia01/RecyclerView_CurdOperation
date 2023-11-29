package com.example.recyclerviewactivity

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(var context: Context, var dataArrayList: ArrayList<DataClass>) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.contactName)
        var phone: TextView = itemView.findViewById(R.id.ContactNumber)
        var img: ImageView = itemView.findViewById(R.id.contact_img)
        var myLayout=itemView.findViewById<ConstraintLayout>(R.id.myLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(dataArrayList[position].img)
        holder.name.text = dataArrayList[position].name
        holder.phone.text = dataArrayList[position].phone

        // Update data
        holder.myLayout.setOnClickListener {
            var dialog = Dialog(context)
            dialog.setContentView(R.layout.add_update)

            var edName = dialog.findViewById<EditText>(R.id.contactName)
            var edPhone = dialog.findViewById   <EditText>(R.id.ContactNumber)
            var updateButton = dialog.findViewById<Button>(R.id.AUBtn)

            updateButton.text = "Update Data"
            edName.setText(dataArrayList[position].name)
            edPhone.setText(dataArrayList[position].phone)

            updateButton.setOnClickListener {
                var name = edName.text.toString()
                var phone = edPhone.text.toString()

                if (name.isNotEmpty() && phone.isNotEmpty()) {
                    // Update the data in the ArrayList
                    dataArrayList[position] = DataClass(R.drawable.a, name, phone)
                    notifyItemChanged(position)
                }
                dialog.dismiss()
            }
            dialog.show()
        }
        //Delete Data
        holder.myLayout.setOnLongClickListener {
            val dialog = AlertDialog.Builder(context)

            dialog.setTitle("Delet project list")
            dialog.setMessage("You want to delete project?")
            dialog.setIcon(R.drawable.delete_24)
            dialog.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                dataArrayList.removeAt(position)
                notifyItemRemoved(position)
            })
                .setNegativeButton("No",null)
                dialog.show()
            return@setOnLongClickListener true
                }

            }  

    override fun getItemCount(): Int {
        return dataArrayList.size
    }
}
