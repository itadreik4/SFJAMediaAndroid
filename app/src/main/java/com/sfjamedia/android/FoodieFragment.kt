package com.sfjamedia.android

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
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
        if (mListener != null) { mListener!!.onFragmentInteraction("FoodieThing") }
        return inflater.inflate(R.layout.fragment_foodie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val uri = "android.resource://com.sfjamedia.android/"

        imageft.setOnClickListener {
            val likeIng = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/foodiething"))
                    .setPackage("com.instagram.android")
            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context,"Instagram not installed, using browser", Toast.LENGTH_SHORT).show()
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/foodiething")))
            }
        }

        GlobalScope.launch (Dispatchers.Main){
            videoView1.setVideoURI(Uri.parse(uri + R.raw.jalapenopoppers))
            videoView1.setOnCompletionListener { videoView1.start() }
            videoView1.start()
            foodie_scroll.fullScroll(ScrollView.FOCUS_UP)
        }

        chip1.isEnabled = false

        chipgroup.setOnCheckedChangeListener { group, checkedId ->
            if (chip1.isChecked) {
                chip1.isEnabled = false
                chip2.isEnabled = true
                chip3.isEnabled = true
                chip4.isEnabled = true
                chip5.isEnabled = true
                videoView1.setVideoURI(Uri.parse(uri + R.raw.jalapenopoppers))
                videoView1.setOnCompletionListener { videoView1.start() }
                videoView1.start()
            }
            if (chip2.isChecked) {
                chip1.isEnabled = true
                chip2.isEnabled = false
                chip3.isEnabled = true
                chip4.isEnabled = true
                chip5.isEnabled = true
                videoView1.setVideoURI(Uri.parse(uri + R.raw.macncheese))
                videoView1.setOnCompletionListener { videoView1.start() }
                videoView1.start()
            }
            if (chip3.isChecked) {
                chip1.isEnabled = true
                chip2.isEnabled = true
                chip3.isEnabled = false
                chip4.isEnabled = true
                chip5.isEnabled = true
                videoView1.setVideoURI(Uri.parse(uri + R.raw.cookie))
                videoView1.setOnCompletionListener { videoView1.start() }
                videoView1.start()
            }
            if (chip4.isChecked) {
                chip1.isEnabled = true
                chip2.isEnabled = true
                chip3.isEnabled = true
                chip4.isEnabled = false
                chip5.isEnabled = true
                videoView1.setVideoURI(Uri.parse(uri + R.raw.fruitpebbles))
                videoView1.setOnCompletionListener { videoView1.start() }
                videoView1.start()
            }
            if (chip5.isChecked) {
                chip1.isEnabled = true
                chip2.isEnabled = true
                chip3.isEnabled = true
                chip4.isEnabled = true
                chip5.isEnabled = false
                videoView1.setVideoURI(Uri.parse(uri + R.raw.jalapenopoppers))
                videoView1.setOnCompletionListener { videoView1.start() }
                videoView1.start()
            }

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
