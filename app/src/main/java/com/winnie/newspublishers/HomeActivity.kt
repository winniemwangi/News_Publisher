package com.winnie.newspublishers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.winnie.newspublishers.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
        signUp()
        displayNews()
    }

    fun login(){
        binding.tvlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun signUp(){
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    fun displayNews(){
        var publish1 = News("https://upload.wikimedia.org/wikipedia/commons/9/9f/TOKO-logo-1000x1000px.jpg", "Entertainment", "https://nnmedia.nation.africa/uploads/2018/07/BahatiDiana.jpg", "EXCLUSIVE: Gospel musician Bahati lands multi-million deal for his reality TV show", " Gospel musician Kevin Bahati has landed a multi-million deal for his upcoming reality TV show that will air on NTV.")
        var publish2 = News("https://pbs.twimg.com/profile_images/1493471722863005696/TZUfihSA_400x400.jpg", "Lifestyle", "https://nairobifashionhub.co.ke/wp-content/uploads/2022/07/Nairobi-Fashion-Hub-Free-State-Fashion-Week-2022.jpg", "African Fashion Show: The Focus Is Back On Fashion Presentations, The Upcoming Season Will Look Like This.", " Before showcasing their collections to a larger audience of fashion buyers, the media, critics, and the general public at the fashion fair, the student designers are required to critique each other’s work as part of their weekly assignments under the guidance of Fezile Mdletshe, managing director and founder of the Fezile Fashion Skills Academy.")
        var publish3 = News("https://upload.wikimedia.org/wikipedia/en/e/ec/KTN.2014-present_logo.jpg", "Sports", "https://cdn.dmcl.biz/media/image/217340/o/GettyImages-1234572167.jpg", "Eliud Kipchoge Foundation to fund libraries and forests across Kenya and beyond following launch", "Double Olympic marathon champion Eliud Kipchoge plans to build a library in every school in Kenya and to plant a forest in all 47 counties of his native country as part of the first stage of projects within the Eliud Kipchoge Foundation, which launched today.")
        var publish4 = News("https://upload.wikimedia.org/wikipedia/en/8/86/KBC_Kenya.PNG", "Business", "https://www.financialfortunemedia.com/wp-content/uploads/2020/12/kenya-smes.jpg", "Kenyan Businesses Optimistic Despite Covid-19 ‘Second Wave’", "Close to 50 percent of manufacturing companies have already recovered business or expect to do so by the end of 2020 a global online survey released today indicates.")
        var publish5 = News("https://www.logolynx.com/images/logolynx/08/08340886b72eb118fc4cc9c5d3fb45dc.jpeg", "Education", "https://www.arcgis.com/sharing/rest/content/items/ea450696c6524c23aba3903095f7e6ae/info/thumbnail/ago_downloaded.jpg/?w=800", "Access to primary schools and quality of education in Kenya", "In many Kenyan counties, children must travel long distances to attend school. Some counties have very few schools compared to the population density.")
        var publish6 = News("https://www.channelthon.com/wp-content/uploads/2020/08/citizen-tv-official-youtube-channel.png", "Love & Dating", "https://www.capitalfm.co.ke/lifestyle/files/2021/10/Unwind-Rebalance-2-1024x683.jpg", "Most Kenyan women would do anything to save their relationship/marriage, says marriage counsellor", "A man and a woman in a relationship can look at the same issues so differently leading to conflict")




        var publishList = listOf( publish1, publish2, publish3, publish4, publish5, publish6)

        var newsAdapter = NewsRVAdapter(publishList)
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = newsAdapter
    }


}