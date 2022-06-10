package developer.abdulaziz.homework22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulaziz.homework22.DB.MyDBHelper
import developer.abdulaziz.homework22.DB.User
import developer.abdulaziz.homework22.MyShared.MyShared
import developer.abdulaziz.homework22.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var myDBHelper: MyDBHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)
        binding.apply {
            MyShared.init(root.context)
            val list = MyShared.sharedList
            addSave.setOnClickListener {
                if (addMovie.text.isNotEmpty() && authorMovie.text.isNotEmpty() && aboutMovie.text.isNotEmpty() && dataMovie.text.isNotEmpty()) {
                    val user = User(
                        addMovie.text.toString(),
                        authorMovie.text.toString(),
                        aboutMovie.text.toString(),
                        dataMovie.text.toString()
                    )
                    myDBHelper = MyDBHelper(root.context)
                    myDBHelper.createUser(user)
                    list.add(user)
                    MyShared.sharedList = list
                    findNavController().popBackStack()
                } else {
                    Toast.makeText(root.context, "Ma'lumot yetarli emas", Toast.LENGTH_SHORT).show()
                }
            }

            return binding.root
        }
    }
}