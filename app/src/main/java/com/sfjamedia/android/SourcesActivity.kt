package com.sfjamedia.android

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sources.*

class SourcesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sources)

        label_material_design.movementMethod = LinkMovementMethod.getInstance()
        label_material_icons.movementMethod = LinkMovementMethod.getInstance()
        label_navigation.movementMethod = LinkMovementMethod.getInstance()
        label_androidktx.movementMethod = LinkMovementMethod.getInstance()

    }
}