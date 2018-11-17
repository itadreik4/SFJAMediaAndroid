package com.sfjamedia.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_contact.*


class ContactFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (mListener != null) { mListener!!.onFragmentInteraction("Contact") }
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        send_message.setOnClickListener {
            val nameString = view.findViewById<EditText>(R.id.name_text).text.toString()
            val emailString = view.findViewById<EditText>(R.id.email_text).text.toString()
            val messageString = view.findViewById<EditText>(R.id.message_text).text.toString()

            if (nameString.length < 2 || emailString.length < 6 || messageString.length < 2) {
                Snackbar.make(activity!!.findViewById(android.R.id.content), "Please fill out the form", Snackbar.LENGTH_SHORT).show()

            } else if (emailString.contains("@")) {
                if (emailString.startsWith("@") || emailString.endsWith("@")) {
                    Snackbar.make(activity!!.findViewById(android.R.id.content), "Please enter a valid email address", Snackbar.LENGTH_SHORT).show()
                } else {
                    val finalMessage = ("Name: " + nameString
                            + "\nEmail: " + emailString
                            + "\nMessage: " + messageString)
                    val emailIntent = Intent(Intent.ACTION_SEND)
                    val aEmailList = arrayOf("inquiries@sfjamedia.com")
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList)
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SFJA Inquiry")
                    emailIntent.type = "plain/text"
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, finalMessage)
                    startActivity(Intent.createChooser(emailIntent, "Choose your email client"))
                }

            } else {
                Snackbar.make(activity!!.findViewById(android.R.id.content), "Please enter a valid email", Snackbar.LENGTH_SHORT).show()
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


