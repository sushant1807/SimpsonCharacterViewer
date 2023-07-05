package com.sushant.simpsoncharacterviewer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sushant.simpsoncharacterviewer.databinding.ActivityMainBinding
import com.sushant.simpsoncharacterviewer.network.AppModule
import com.sushant.simpsoncharacterviewer.factory.SimpsonsViewModelFactory
import com.sushant.simpsoncharacterviewer.model.RelatedTopic
import com.sushant.simpsoncharacterviewer.repository.SimpsonsRepository
import com.sushant.simpsoncharacterviewer.util.Constants
import com.sushant.simpsoncharacterviewer.viewmodel.SimpsonsViewModel

class MainActivity : AppCompatActivity(), SimpsonsViewAdapter.SimpsonItemListener {

    lateinit var viewModel: SimpsonsViewModel
    private lateinit var adapter: SimpsonsViewAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpServiceConnections()
    }

    private fun setUpServiceConnections() {
        val retrofitService = AppModule.getInstance()
        val mainRepository = SimpsonsRepository(retrofitService)

        adapter = SimpsonsViewAdapter(this)
        binding.recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, SimpsonsViewModelFactory(mainRepository)).get(SimpsonsViewModel::class.java)

        viewModel.cityList.observe(this){
            if (it != null) {
                it.relatedTopics?.let { it1 -> adapter.setSimpsonsData(it1) }
            }
        }

        viewModel.getSimpsonsData()
    }

    override fun onClickedSimpsonItem(relatedTopic: RelatedTopic) {
        Toast.makeText(this, relatedTopic.text.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent(application, SimpsonsDetailsActivity::class.java)
        intent.putExtra(Constants.RELATED_TOPIC, relatedTopic)
        startActivity(intent)
    }
}