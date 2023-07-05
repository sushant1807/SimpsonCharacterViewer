package com.sushant.simpsoncharacterviewer.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sushant.simpsoncharacterviewer.R
import com.sushant.simpsoncharacterviewer.databinding.ActivityDetailsBinding
import com.sushant.simpsoncharacterviewer.model.RelatedTopic
import com.sushant.simpsoncharacterviewer.util.Constants

class SimpsonsDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val relatedTopic = intent.getParcelableExtra(Constants.RELATED_TOPIC, RelatedTopic::class.java)

        if (relatedTopic != null) {
            setUpUIInfo(relatedTopic)
        }
    }

    private fun setUpUIInfo(relatedTopic: RelatedTopic) {
        binding.detailTvTitle.text = relatedTopic.text
        Glide.with(this).load(relatedTopic.icon?.url)
            .placeholder(R.drawable.person)
            .error(R.drawable.person)
            .apply(RequestOptions().centerCrop())
            .into(binding.imageView)

        binding.btnSearch.setOnClickListener {
            intent= Intent(Intent.ACTION_VIEW, Uri.parse(relatedTopic.firstURL))
            startActivity(intent)
        }
    }
}