package developer.abdulaziz.homework22

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulaziz.homework22.DB.MyDBHelper
import developer.abdulaziz.homework22.DB.User
import developer.abdulaziz.homework22.MyShared.MyData
import developer.abdulaziz.homework22.databinding.FragmentAboutBinding

@SuppressLint("SetTextI18n")
class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    private lateinit var myDBHelper: MyDBHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(layoutInflater)
        binding.apply {
            myDBHelper = MyDBHelper(root.context)
            val list = myDBHelper.readUser()

            aboutName.text = "Movie name: ${list[MyData.myPos].name}"
            aboutAuthors.text = "Movie authors: ${list[MyData.myPos].author}"
            aboutAbout.text = "About movie: ${list[MyData.myPos].about}"
            aboutData.text = "Movie date: ${list[MyData.myPos].data}"
            close.setOnClickListener {
                findNavController().popBackStack()
            }

            return root
        }
    }
}