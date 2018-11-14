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

        GlobalScope.launch (Dispatchers.Main){
            videoView2.setVideoURI(Uri.parse(uri + R.raw.fruitpebbles))
            videoView2.setOnCompletionListener { videoView2.start() }
            videoView2.start()
        }

        GlobalScope.launch (Dispatchers.Main) {
            videoView3.setVideoURI(Uri.parse(uri + R.raw.cookie))
            videoView3.setOnCompletionListener { videoView3.start() }
            videoView3.start()
        }

        GlobalScope.launch (Dispatchers.Main) {
            videoView4.setVideoURI(Uri.parse(uri + R.raw.macncheese))
            videoView4.setOnCompletionListener { videoView4.start() }
            videoView4.start()
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
