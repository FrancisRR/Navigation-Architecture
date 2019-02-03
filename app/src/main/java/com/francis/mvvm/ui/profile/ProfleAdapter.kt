package com.francis.mvvm.ui.profile

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.francis.mvvm.R

class ProfleAdapter(val context: Context?, val listener: ClickListener?) :
    RecyclerView.Adapter<ProfleAdapter.ProfileHolder>() {

    private var actionList: ArrayList<ProfileAction>? = arrayListOf()

    open interface ClickListener {
        fun onItemClick(position: Int, item: ProfileAction)
    }

    fun setAdapterList(mList: ArrayList<ProfileAction>?) {
        actionList?.clear()
        if (mList == null) return else {
            actionList?.addAll(mList)
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfleAdapter.ProfileHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false)
        return ProfileHolder(view)
    }

    override fun getItemCount() = actionList!!.size

    override fun onBindViewHolder(holder: ProfleAdapter.ProfileHolder, position: Int) {
        val ProfileAction = actionList?.get(position)
        holder.bindDataToView(position, ProfileAction)
    }

    open class ProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.tvActionName)
        lateinit var tvActionName: TextView
        @BindView(R.id.view_top)
        lateinit var topView: View

        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener {
                Log.e("TAG", "CLICK")
            }
        }

        internal fun bindDataToView(position: Int, item: ProfileAction?) {
            topView.visibility = View.GONE
            tvActionName.setText(item?.name)
        }

    }
}