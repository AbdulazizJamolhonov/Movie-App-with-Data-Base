package developer.abdulaziz.homework22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import developer.abdulaziz.homework22.DB.User
import developer.abdulaziz.homework22.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.my_container).navigateUp()
}

fun main() {
    var number = 1
    val array = ArrayList<Int>()
    val text = Scanner(System.`in`).nextInt()
    while (number != 0) {
        if (text % 2 == 0) {
            number /= text
            array.add(0)
        } else {

        }
    }
}