package av.ponomarev.form

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import av.ponomarev.form.databinding.LandscapeBinding

lateinit var bind1 : LandscapeBinding

class Landscape : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = LandscapeBinding.inflate(layoutInflater).also { setContentView(it.constraint) }
        bind1 = binding
        binding.radioButton.setOnClickListener(radioButtonClickListener)
        binding.radioButton1.setOnClickListener(radioButtonClickListener)
        binding.tv10.isVisible = false
        binding.tv11.isVisible = false
    }

    private var radioButtonClickListener =
        View.OnClickListener { v ->
            val rb = v as RadioButton
            when (rb.id) {
                bind1.radioButton.id -> {
                    bind1.tv10.isVisible = true
                    bind1.tv11.isVisible = true
                }
                bind1.radioButton1.id -> {
                    bind1.tv10.isVisible = false
                    bind1.tv11.isVisible = false
                }
                else -> {}
            }
        }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setSpecificLayout(newConfig.orientation)
    }

    private fun setSpecificLayout(orientation: Int){
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.landscape);
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
    }
}