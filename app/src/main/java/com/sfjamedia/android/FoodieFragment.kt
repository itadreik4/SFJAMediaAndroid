package com.sfjamedia.android

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_foodie.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.android.Main
import kotlinx.coroutines.launch
import android.util.DisplayMetrics




class FoodieFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (mListener != null) { mListener!!.onFragmentInteraction("Foodie Thing") }


        return inflater.inflate(R.layout.fragment_foodie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val uri = "android.resource://com.sfjamedia.android/"



        GlobalScope.launch (Dispatchers.Main){
            videoView1.setVideoURI(Uri.parse(uri + R.raw.jalapenopoppers))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
        }

        chip1.setOnClickListener {
            videoView1.setVideoURI(Uri.parse(uri + R.raw.jalapenopoppers))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
        }
        chip2.setOnClickListener {
            videoView1.setVideoURI(Uri.parse(uri + R.raw.macncheese))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
        }
        chip3.setOnClickListener {
            videoView1.setVideoURI(Uri.parse(uri + R.raw.cookie))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
        }
        chip4.setOnClickListener {
            videoView1.setVideoURI(Uri.parse(uri + R.raw.fruitpebbles))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
        }
        chip5.setOnClickListener {
            videoView1.setVideoURI(Uri.parse(uri + R.raw.macncheese))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
        }



    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            mListener = context as OnFragmentInteractionListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }


    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(title: String)
    }
}
