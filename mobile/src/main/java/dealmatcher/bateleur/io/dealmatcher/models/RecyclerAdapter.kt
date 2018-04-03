package dealmatcher.bateleur.io.dealmatcher.models

import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dealmatcher.bateleur.io.dealmatcher.R
import java.net.URL


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val urlTakealotDeals = "https://api.takealot.com/rest/v-1-6-0/productlines/search?sort=BestSelling%20Descending&rows=100&daily_deals_rows=100&start=0&detail=listing&filter=Available:true&filter=Promotions:54634";
    private var list = ArrayList<DealItem>()

    var task: AsyncTask<Void, Void, String>? = null
    fun refresh() {
        list = ArrayList<DealItem>()
        task = object: AsyncTask<Void, Void, String>() {
            override fun doInBackground(vararg params: Void): String {
                val json = URL(urlTakealotDeals).readText()
                return "";
            }
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)

//                MyprogressBar.visibility = View.INVISIBLE;
//
//                if (result == "") {
//                    my_text.text = "Network Error";
//                } else {
//                    my_text.text = result;
//                }

//                if (task != null) {
//                    task.cancel(true)
//                    task = null
//                }
            }
        }
    }
    private val titles = arrayOf("Chapter One",
            "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven",
            "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item file details", "Item six details",
            "Item seven details", "Item eight details")

    private val images = intArrayOf(R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery, R.drawable.ic_menu_manage,
            R.drawable.ic_menu_send, R.drawable.ic_menu_share,
            R.drawable.ic_menu_slideshow, R.drawable.abc_ic_menu_copy_mtrl_am_alpha,
            R.drawable.abc_ic_arrow_drop_right_black_24dp)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.fragment_dealitem, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
    override fun getItemCount(): Int {
        return titles.size
    }
}
