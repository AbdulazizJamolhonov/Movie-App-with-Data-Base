package developer.abdulaziz.homework22

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulaziz.homework22.Adapters.HomeAdapter
import developer.abdulaziz.homework22.Adapters.MyOnClickListener
import developer.abdulaziz.homework22.DB.MyDBHelper
import developer.abdulaziz.homework22.DB.User
import developer.abdulaziz.homework22.MyShared.MyData
import developer.abdulaziz.homework22.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var myDBHelper: MyDBHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.apply {
            myDBHelper = MyDBHelper(root.context)

            imageAdd.setOnClickListener {
                findNavController().navigate(R.id.addFragment)
            }

            homeAdapter = HomeAdapter(myDBHelper.readUser(), object : MyOnClickListener {
                override fun editMovie(user: User, position: Int) {
                    MyData.myPos = position
                    findNavController().navigate(R.id.editFragment, bundleOf("userInfo" to user))
                }

                override fun deleteMovie(user: User, position: Int) {
                    myDBHelper.deleteUser(user)
                    homeAdapter.notifyItemRemoved(position)
                }

                override fun onClick(position: Int) {
                    MyData.myPos = position
                    findNavController().navigate(R.id.aboutFragment)
                }
            })
            myRv.adapter = homeAdapter

            return binding.root
        }
    }
}