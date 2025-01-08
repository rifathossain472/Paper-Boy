package com.esports.webviewapp.starter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esports.webviewapp.R
import com.esports.webviewapp.data.Item
import com.esports.webviewapp.databinding.ActivityMainBinding
import com.esports.webviewapp.recyclerView.Adapter
import com.esports.webviewapp.webView.WebViewActivity

class MainActivity : AppCompatActivity(), Adapter.HandleClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageList = listOf(
            R.drawable.amarsongbad_yes,
            R.drawable.janakantha_yes,
            R.drawable.bangladesh_protidin_yes,
            R.drawable.kalbela_yes,
            R.drawable.noya_digonto_yes,
            R.drawable.prothom_alo_yes,
            R.drawable.amadersomoy,
            R.drawable.amar_desh,
            R.drawable.bangla_tribune,
            R.drawable.bbc_bangla,
            R.drawable.bdnews,
            R.drawable.daily_campus,
            R.drawable.daily_star_bangla,
            R.drawable.dhaka_times,
            R.drawable.dw_bengali,
            R.drawable.inqilab,
            R.drawable.ittefak,
            R.drawable.jago_news,
            R.drawable.jai_jai_din,
            R.drawable.jugantor,
            R.drawable.korotoa,
            R.drawable.manab_jamin,
            R.drawable.manab_kantho,
            R.drawable.rtv,
            R.drawable.somokal,
            R.drawable.somoy,
            R.drawable.dhaka_tribune,
            R.drawable.gono_kontho,
        )

        val itemList = listOf(
            Item(imageList[0], "https://www.amarsangbad.com/"),
            Item(imageList[1], "https://www.dailyjanakantha.com/"),
            Item(imageList[2], "https://www.bd-pratidin.com/"),
            Item(imageList[3], "https://www.kalbela.com/"),
            Item(imageList[4], "https://www.dailynayadiganta.com/"),
            Item(imageList[5], "https://www.prothomalo.com/"),
            Item(imageList[6], "https://www.dainikamadershomoy.com/"),
            Item(imageList[7], "https://dailyamardesh.com/"),
            Item(imageList[8], "https://www.banglatribune.com/"),
            Item(imageList[9], "https://www.bbc.com/bengali"),
            Item(imageList[10], "https://bangla.bdnews24.com/"),
            Item(imageList[11], "https://thedailycampus.com/"),
            Item(imageList[12], "https://bangla.thedailystar.net/"),
            Item(imageList[13], "https://www.dhakatimes24.com/"),
            Item(imageList[14], "https://www.dw.com/bn/%E0%A6%AC%E0%A6%BF%E0%A6%B7%E0%A7%9F/s-11929"),
            Item(imageList[15], "https://dailyinqilab.com/"),
            Item(imageList[16], "https://www.ittefaq.com.bd/"),
            Item(imageList[17], "https://www.jagonews24.com/"),
            Item(imageList[18], "https://www.jaijaidinbd.com/"),
            Item(imageList[19], "https://www.jugantor.com/"),
            Item(imageList[20], "https://www.dailykaratoa.com/"),
            Item(imageList[21], "https://mzamin.com/"),
            Item(imageList[22], "https://www.manobkantha.com.bd/"),
            Item(imageList[23], "https://www.rtvonline.com/"),
            Item(imageList[24], "https://samakal.com/"),
            Item(imageList[25], "https://www.somoynews.tv/"),
            Item(imageList[26], "https://bangla.dhakatribune.com/"),
            Item(imageList[27], "https://www.gonokantho.com/"),
        )

        adapter = Adapter(itemList, this@MainActivity)
        binding.rvLayout.adapter = adapter

    }

    override fun clickItem(url: String) {
        val webIntent = Intent(this@MainActivity, WebViewActivity::class.java)
        webIntent.putExtra("name", url)
        startActivity(webIntent)
    }
}