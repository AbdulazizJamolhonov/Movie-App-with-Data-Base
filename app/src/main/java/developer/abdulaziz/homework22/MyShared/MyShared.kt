package developer.abdulaziz.homework22.MyShared

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import developer.abdulaziz.homework22.DB.User

object MyShared {
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("myCacheFile", Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var sharedList: ArrayList<User>
        get() = gsonStringToList(sharedPreferences.getString("keyList", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("keyList", listToGsonString(value))
        }

    private fun gsonStringToList(gsonString: String): ArrayList<User> =
        Gson().fromJson(gsonString, object : TypeToken<ArrayList<User>>() {}.type)

    private fun listToGsonString(list: ArrayList<User>): String = Gson().toJson(list)
}