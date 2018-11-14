package com.sfjamedia.android

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_links.*


class LinksFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (mListener != null) { mListener!!.onFragmentInteraction("Links") }

        contentFrameLayout3.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://sfjamedia.com/")))
        }

        contentFrameLayout.setOnClickListener {
            val likeIng = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/foodiething"))
                    .setPackage("com.instagram.android")
            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context,"Instagram not installed, using browser", Toast.LENGTH_SHORT).show()
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/foodiething")))
            }
        }

        contentFrameLayout2.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://sfjamedia.com/store")))
        }

        contentFrameLayout4.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://sfjamedia.com/merch")))
        }

        opensoftware.setOnClickListener {
            startActivity(Intent(activity, SourcesActivity::class.java))
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
