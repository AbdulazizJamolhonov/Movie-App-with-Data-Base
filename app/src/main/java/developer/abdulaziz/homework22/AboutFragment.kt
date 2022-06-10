package developer.abdulaziz.homework22

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulaziz.homework22.DB.User
import developer.abdulaziz.homework22.MyShared.MyData
import developer.abdulaziz.homework22.databinding.FragmentAboutBinding

@SuppressLint("SetTextI18n")
class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    private lateinit var list: ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(layoutInflater)
        binding.apply {
            MyShared.init(root.context)

            aboutName.text = "Movie name: ${MyShared.sharedList[MyData.myPos].name}"
            aboutAuthors.text = "Movie authors: ${MyShared.sharedList[MyData.myPos].author}"
            aboutAbout.text = "About movie: ${MyShared.sharedList[MyData.myPos].about}"
            aboutData.text = "Movie date: ${MyShared.sharedList[MyData.myPos].data}"
            close.setOnClickListener {
                findNavController().popBackStack()
            }

            return root
        }
    }
}