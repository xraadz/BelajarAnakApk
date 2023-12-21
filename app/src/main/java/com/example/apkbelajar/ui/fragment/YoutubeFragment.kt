package com.example.apkbelajar.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apkbelajar.R
import com.example.apkbelajar.adapter.AdapterYoutube
import com.example.apkbelajar.models.Youtube
import com.example.apkbelajar.utils.BackgroundServices
import kotlinx.android.synthetic.main.fragment_youtube.*
import kotlinx.android.synthetic.main.fragment_youtube.img_rogo

class YoutubeFragment : Fragment() {

    companion object {
        fun newInstance() = YoutubeFragment()
    }

    private var list: ArrayList<Youtube> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_youtube, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //LoadItem
        rvYoutube.setHasFixedSize(true)
        list.addAll(com.example.apkbelajar.data.Youtube.listData)
        //Load Item to RecyclerView
        rvYoutube.layoutManager = LinearLayoutManager(view?.context)
        val adapterYT = AdapterYoutube(list)
        rvYoutube.adapter = adapterYT

        //Deklarasi animasi
        val animScale = AnimationUtils.loadAnimation(view?.context, R.anim.scale)
        val animTopToButton = AnimationUtils.loadAnimation(view?.context, R.anim.toptobutton)
        //Menerapkan Animasi
        img_rogo.animation = animTopToButton
        belajarangka.animation = animTopToButton
        rvYoutube.animation = animScale
    }

    override fun onResume() {
        super.onResume()
        view?.context?.startService(Intent(view?.context, BackgroundServices::class.java))
    }
}