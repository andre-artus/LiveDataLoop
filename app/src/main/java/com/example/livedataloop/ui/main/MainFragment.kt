package com.example.livedataloop.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.livedataloop.databinding.MainFragmentBinding
import timber.log.Timber

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.item = viewModel
        viewModel.readingText.observe(this, Observer {
            Timber.d(it ?: "-1")
        })

        binding.buttonSubmit.setOnClickListener {
            val imageIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (imageIntent.resolveActivity(activity!!.packageManager) != null) {
                startActivityForResult(imageIntent, ACTION_TAKE_PICTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.d("$requestCode $resultCode")
    }


    companion object {
        fun newInstance() = MainFragment()
        private const val ACTION_TAKE_PICTURE = 1
    }

}
